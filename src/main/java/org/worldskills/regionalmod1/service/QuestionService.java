package org.worldskills.regionalmod1.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.worldskills.regionalmod1.model.Grade;
import org.worldskills.regionalmod1.model.Question;
import org.worldskills.regionalmod1.model.Subject;
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
        if (StringUtils.isBlank(subject) && StringUtils.isNotBlank(grade)) {
            return this.questionRepository.searchQuestionByGrade(EnumUtils.getEnum(Grade.class, grade));
        } else if (StringUtils.isBlank(grade) && StringUtils.isNotBlank(subject)) {
            return this.questionRepository.searchQuestionBySubject(EnumUtils.getEnum(Subject.class, subject));
        } else if (StringUtils.isNoneBlank(grade, subject)) {
            return this.questionRepository.searchQuestionByGradeAndSubject(EnumUtils.getEnum(Grade.class, grade), EnumUtils.getEnum(Subject.class, subject));
        } else {
            return this.questionRepository.findAll();
        }

    }
}
