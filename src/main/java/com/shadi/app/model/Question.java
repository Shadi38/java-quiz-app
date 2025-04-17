package com.shadi.app.model;

//to represent each table of the database we create a class(we call them Entities ,or we call them Model in MVC model)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
// we use ORM (object relational mapping).
//each object represent the row in our table in database

@Entity
//instead of implementing two method (getter and setter ) for every variable, we use @Data from Lombok
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
