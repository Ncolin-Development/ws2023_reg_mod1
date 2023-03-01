package org.worldskills.regionalmod1.service;

import org.springframework.stereotype.Service;
import org.worldskills.regionalmod1.model.Subject;

import java.util.Arrays;
import java.util.List;

@Service
public class SubjectService {

    public List<Subject> getAllSubjects() {
        return Arrays.asList(Subject.values());
    }
}
