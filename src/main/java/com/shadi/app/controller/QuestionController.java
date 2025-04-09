package com.shadi.app.controller;
//we want to create this url => http://localhost:8080/question/allQuestions

import com.shadi.app.model.Question;
import com.shadi.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//we want to accept the request in this class. for this we use RestController
@RestController
// we want to mention a path for question (localhost:8080/question)
@ RequestMapping("question")
public class QuestionController {
//create an object from QuestionService
    @Autowired
    QuestionService questionService;
    //we want to have this url==> localhost:8080/question/allQuestions(we use @getMapping because we want to get data)
    @GetMapping("allQuestions")

//    //below method returns a list of objects(rows in database table)
//    public List<Question> getAllQuestions() {
//    // we want to fetch questions from database
//        return questionService.getAllQuestions;
//    }


    //we want to return data as well as status code to the client with using ResponseEntity<>
    public ResponseEntity<ResponseEntity<List<Question>>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        //we created a new object of ResponseEntity.it will have 2 parameters:
        //1-data which we want to return. 2-status code
    }

    //it means we want to fetch database on category
    // below class(getQuestionByCategory) should accept the value(for example java for this url:localhost:8080/question/category/java)
    @GetMapping("category/{category}")
    //public List<Question> getQuestionByCategory(@PathVariable String category){
    //   return questionService.getQuestionsByCategory(category);
    //    }

    //we want to return data as well as status code to the client with using ResponseEntity<>
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    //we want to add question on database(we want below method return the sentence)
    //below method should receive the question from body)
    //we want to have this url==> localhost:8080/question/add
    @PostMapping("add")
//    public String addQuestion(@RequestBody Question question) {
//        return questionService.addQuestion(question);
//    }
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
}

//