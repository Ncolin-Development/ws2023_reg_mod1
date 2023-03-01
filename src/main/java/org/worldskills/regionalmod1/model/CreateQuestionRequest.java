package org.worldskills.regionalmod1.model;

import lombok.Data;

@Data
public class CreateQuestionRequest {

    private String title;
    private Boolean active;
    private String author;
    private String grade;
    private String subject;
}
