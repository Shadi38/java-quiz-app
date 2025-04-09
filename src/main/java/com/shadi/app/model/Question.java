package com.shadi.app.model;

//to represent each table of the database we create a class(we call them Entities ,or we call them Model in MVC model)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
// we use ORM (object relational mapping). we create variables that represent our columns in our database's table
//the number of object that we have for this class,each object represent the row in our table in database


//we want to our table in database be able to map with this class(the name of the table should be the same as the class name). because of that we have to use @Entity
@Entity
//instead of implementing two method (getter and setter ) for every variable, we use @Data from Lombok (we configured Lombok in pom.xml)
@Data
public class Question {

    // we make sure the id is primary key and this id wil be auto generated
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
