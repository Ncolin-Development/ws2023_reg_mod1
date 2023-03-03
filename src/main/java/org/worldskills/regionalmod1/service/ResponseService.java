package org.worldskills.regionalmod1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.worldskills.regionalmod1.exception.NotFoundException;
import org.worldskills.regionalmod1.model.Response;
import org.worldskills.regionalmod1.repository.QuestionRepository;
import org.worldskills.regionalmod1.repository.ResponseRepository;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;

    /**
     * Searches the response for a given questionId
     *
     * @param questionId id of a question
     * @return iterable of responses
     */
    public Iterable<Response> getResponsesForQuestionId(Long questionId) {
        if (!this.questionRepository.existsById(questionId)) {
            throw new NotFoundException(String.format("Question %s does not exist", questionId));
        }
        return this.responseRepository.findAllByQuestionId(questionId);
    }

    /**
     * Deletes responses of a specific question
     *
     * @param questionId id of question
     */
    public void deleteByQuestionId(Long questionId) {
        this.getResponsesForQuestionId(questionId).forEach(this.responseRepository::delete);
    }
}
