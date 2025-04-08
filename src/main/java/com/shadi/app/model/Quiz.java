package com.shadi.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
//making a Quiz a table with @Entity
@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    //one quiz can have multiple questions and each question can be for multiple quizzes(for this approach we should do Many to Many mapping)
    @ManyToMany
    private List<Question> questions;

}
