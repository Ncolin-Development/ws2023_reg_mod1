package org.worldskills.regionalmod1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worldskills.regionalmod1.model.Question;
import org.worldskills.regionalmod1.service.QuestionService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> searchQuestions(@RequestParam(value = "grade", required = false) String grade, @RequestParam(value = "subject", required = false) String subject) {
        return ok().body(this.questionService.searchQuestions(subject, grade));
    }
}
