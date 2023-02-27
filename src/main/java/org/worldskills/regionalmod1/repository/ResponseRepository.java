package org.worldskills.regionalmod1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.worldskills.regionalmod1.model.Response;

@Repository
public interface ResponseRepository extends PagingAndSortingRepository<Response, Long> {
}
