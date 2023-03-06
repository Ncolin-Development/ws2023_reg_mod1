package org.worldskills.regionalmod1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.worldskills.regionalmod1.model.Grade;
import org.worldskills.regionalmod1.model.Question;
import org.worldskills.regionalmod1.model.Subject;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

    @Query("select q from Question q where q.subject= ?1")
    Iterable<Question> searchQuestionBySubject(Subject subject);

    @Query("select q from Question q where q.grade= ?1")
    Iterable<Question> searchQuestionByGrade(Grade grade);

    @Query("select q from Question q where q.grade= ?1 and q.subject = ?2")
    Iterable<Question> searchQuestionByGradeAndSubject(Grade grade, Subject subject);
}
