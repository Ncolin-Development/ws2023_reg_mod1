package org.worldskills.regionalmod1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Response")
public class Response {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "summary", length = 100)
    private String summary;

    @Column(name = "correct")
    private Boolean correct;

    @Column(name = "explaination", length = 400)
    private String explaination;

    @Column(name = "number", scale = 32)
    private Integer number;

    @JsonIgnore
    @Column(name = "question")
    private Long questionId;
}
