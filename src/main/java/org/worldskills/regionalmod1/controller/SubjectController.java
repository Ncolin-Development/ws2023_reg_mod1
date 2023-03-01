package org.worldskills.regionalmod1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.worldskills.regionalmod1.model.Subject;
import org.worldskills.regionalmod1.service.SubjectService;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    ResponseEntity<List<Subject>> getAllSubjects() {
        return ok().body(this.subjectService.getAllSubjects());
    }
}
