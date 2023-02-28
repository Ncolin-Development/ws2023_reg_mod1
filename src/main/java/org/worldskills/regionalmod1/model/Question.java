package org.worldskills.regionalmod1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "Question")
public class Question {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @JsonIgnore
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Response> responses;
}
