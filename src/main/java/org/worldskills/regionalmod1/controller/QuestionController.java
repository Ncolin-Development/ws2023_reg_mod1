package org.worldskills.regionalmod1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.worldskills.regionalmod1.model.CreateQuestionRequest;
import org.worldskills.regionalmod1.model.Question;
import org.worldskills.regionalmod1.service.QuestionService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> getAllQuestions() {
        return ok().body(this.questionService.getAllQuestions());
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody CreateQuestionRequest question) {
        return ResponseEntity.status(201).body(this.questionService.createQuestion(question));
    }
}
