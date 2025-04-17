package com.shadi.app.controller;

import com.shadi.app.model.Question;
import com.shadi.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
// we want to mention a path for question (localhost:8080/question)
@ RequestMapping("question")
public class QuestionController {
//create an object from QuestionService
    @Autowired
    QuestionService questionService;
    //we want to have this url==> localhost:8080/question/allQuestions
    @GetMapping("allQuestions")

    //below method returns a list of objects(rows in database table)
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // below class(getQuestionByCategory) should accept the value(for example java for this url:localhost:8080/question/category/java)
    @GetMapping("category/{category}")

    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }



    //we want to have this url==> localhost:8080/question/add
    @PostMapping("add")

    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
}

