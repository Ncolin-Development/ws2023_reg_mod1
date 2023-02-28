package org.worldskills.regionalmod1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.worldskills.regionalmod1.model.Grade;
import org.worldskills.regionalmod1.service.GradeService;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    @GetMapping
    ResponseEntity<List<Grade>> getAllGrades() {
        return ok().body(this.gradeService.getAllGrades());
    }
}
