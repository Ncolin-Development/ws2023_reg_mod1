package org.worldskills.regionalmod1.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.worldskills.regionalmod1.exception.BadRequestException;
import org.worldskills.regionalmod1.exception.NotFoundException;
import org.worldskills.regionalmod1.model.CreateQuestionRequest;
import org.worldskills.regionalmod1.model.Grade;
import org.worldskills.regionalmod1.model.Question;
import org.worldskills.regionalmod1.model.Subject;
import org.worldskills.regionalmod1.model.UpdateActiveStatusRequest;
import org.worldskills.regionalmod1.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ResponseService responseService;

    /**
     * Search for questions
     *
     * @param subject subject
     * @param grade grade
     * @return {@link Question}
     */
    public Iterable<Question> searchQuestions(String subject, String grade) {
        this.checkGrade(grade);
        this.checkSubject(subject);

        if (StringUtils.isBlank(subject) && StringUtils.isNotBlank(grade)) {
            return this.questionRepository.searchQuestionByGrade(EnumUtils.getEnum(Grade.class, grade));
        } else if (StringUtils.isBlank(grade) && StringUtils.isNotBlank(subject)) {
            return this.questionRepository.searchQuestionBySubject(EnumUtils.getEnum(Subject.class, subject));
        } else if (StringUtils.isNoneBlank(grade, subject)) {
            return this.questionRepository.searchQuestionByGradeAndSubject(EnumUtils.getEnum(Grade.class, grade), EnumUtils.getEnum(Subject.class, subject));
        } else {
            throw new BadRequestException("At least one of subject or grade must be filled");
        }

    }

    /**
     * Save question
     *
     * @param newQuestion question to save
     * @return new question's id
     */
    public Long createQuestion(CreateQuestionRequest newQuestion) {
        this.checkGrade(newQuestion.getGrade());
        this.checkSubject(newQuestion.getSubject());
        if (StringUtils.isBlank(newQuestion.getTitle())) {
            throw new BadRequestException("Title must not be null");
        }
        if (null == newQuestion.getActive()) {
            throw new BadRequestException("Active must be filled");
        }
        return this.questionRepository.save(this.mapQuestionFromRequest(newQuestion)).getId();
    }

    private void checkSubject(String subject) {
        if (null != subject && !EnumUtils.isValidEnum(Subject.class, subject)) {
            throw new BadRequestException("Subject is not within bounds of the enum");
        }
    }

    private void checkGrade(String grade) {
        if (null != grade && !EnumUtils.isValidEnum(Grade.class, grade)) {
            throw new BadRequestException("Grade is not within bounds of the enum");
        }
    }

    /**
     * Updates active status on a question
     *
     * @param request request
     * @param id id of the question
     * @return updated question
     */
    public Question updateActiveStatus(UpdateActiveStatusRequest request, Long id) {
        if (null == request.getActive()) {
            throw new BadRequestException("Active must be filled");
        }
        Question question = this.questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found"));
        question.setActive(request.getActive());
        return this.questionRepository.save(question);
    }

    /**
     * Deletes question referenced by its id if found
     *
     * @param id id of question
     */
    public void deleteQuestion(Long id) {
        this.questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found"));
        this.responseService.deleteByQuestionId(id);
        this.questionRepository.deleteById(id);
    }

    private Question mapQuestionFromRequest(CreateQuestionRequest questionRequest) {
        return Question.builder()
                .title(questionRequest.getTitle())
                .grade(Grade.valueOf(questionRequest.getGrade()))
                .subject(Subject.valueOf(questionRequest.getSubject()))
                .author(questionRequest.getAuthor())
                .build();
    }
}
