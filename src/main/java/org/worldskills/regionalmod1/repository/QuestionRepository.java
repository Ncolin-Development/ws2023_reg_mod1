package org.worldskills.regionalmod1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.worldskills.regionalmod1.model.Question;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

}
