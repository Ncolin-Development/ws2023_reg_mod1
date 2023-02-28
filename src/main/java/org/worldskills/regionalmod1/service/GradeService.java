package org.worldskills.regionalmod1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.worldskills.regionalmod1.model.Grade;

import java.util.Arrays;
import java.util.List;

@Service
public class GradeService {

    /**
     * Returns list of grades
     *
     * @return {@link Grade}
     */
    public List<Grade> getAllGrades() {
        return Arrays.asList(Grade.values());
    }
}
