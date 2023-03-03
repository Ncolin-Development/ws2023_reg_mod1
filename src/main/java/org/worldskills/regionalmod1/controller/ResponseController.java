package org.worldskills.regionalmod1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.worldskills.regionalmod1.model.Response;
import org.worldskills.regionalmod1.service.ResponseService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping("questions/{id}/responses")
    @ResponseBody
    public ResponseEntity<Iterable<Response>> getResponsesForQuestionId(@PathVariable("id") Long questionId) {
        return ok().body(this.responseService.getResponsesForQuestionId(questionId));
    }
}
