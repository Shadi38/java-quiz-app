package com.shadi.app.controller;

//we want to create a quiz with this url which is Post req  (localhost:8080/quiz/create?category:java&numQ:5&title:JQuiz)

import com.shadi.app.model.Question;
import com.shadi.app.model.QuestionWrapper;
import com.shadi.app.model.Quiz;
import com.shadi.app.model.Response;
import com.shadi.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")

public class quizController {
    @Autowired
    QuizService quizService;
  //1---we create a quiz(it means data goes to our database and we want to have two extra tables :
  //1-quiz table 2-table we can have all questions for a particular quiz )
    @PostMapping("create")
    //we want to have this url==> localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam Integer numQ, @RequestParam String title) {
        return quizService.CreateQuiz(category, numQ, title);
    }
  //2---after creating the quiz, we want to fetch these questions in that quiz.
    // (we have to give the quiz id and fetch all questions related to that id)
    //Get req (localhost:8080/quiz/get/1)
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    //we want to submit the quiz(in below the id is for quiz).we sent two thing to the server: 1-id of quiz 2-user's answers for questions
    //@PostMapping("submit/{id}")
    //in below method we return the score of the exam as an integer
//    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
//        return  quizService.calculateResult(id, responses);
//    }


}
