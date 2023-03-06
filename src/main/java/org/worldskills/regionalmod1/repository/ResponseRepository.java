package org.worldskills.regionalmod1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.worldskills.regionalmod1.model.Response;

@Repository
public interface ResponseRepository extends PagingAndSortingRepository<Response, Long> {

    @Query("select r from Response r WHERE r.questionId = ?1")
    Iterable<Response> findAllByQuestionId(Long questionId);
}
