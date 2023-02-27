package org.worldskills.regionalmod1.model;

import javax.persistence.*;

@Entity
@Table(name = "Response")
public class Response {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "summary", length = 100)
    private String summary;

    @Column(name = "correct")
    private Boolean correct;

    @Column(name = "explaination", length = 400)
    private String explaination;

    @Column(name = "number", scale = 32)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinColumn(name = "id")
    private Question question;
}
