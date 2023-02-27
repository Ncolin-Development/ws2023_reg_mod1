package org.worldskills.regionalmod1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title", length = 120)
    private String title;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "author", length = 64)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", length = 32)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject", length = 32)
    private Subject subject;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Response> responses;
}
