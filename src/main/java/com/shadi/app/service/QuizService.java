package com.shadi.app.service;

import com.shadi.app.dao.QuestionDao;
import com.shadi.app.dao.QuizDao;
import com.shadi.app.model.Question;
import com.shadi.app.model.QuestionWrapper;
import com.shadi.app.model.Quiz;
import com.shadi.app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    //for creating the quiz we have to create a quiz(table  in our database) to store that created quiz(in QuizDao)
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> CreateQuiz(String category, Integer numQ, String title) {

      List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

      Quiz quiz = new Quiz();
      quiz.setTitle(title);
      quiz.setQuestions(questions);
      //with above three lines we created the quiz and with below we want to save the quiz(with QuizDao)
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        //we need to fetch the quiz object from database

        Optional<Quiz> quiz = quizDao.findById(id);
        //with above line we got questions related to quiz(above quiz object has questions)
        //,but we have to convert questions to questionWrapper
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

//    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//        Quiz quiz = quizDao.findById(id).get();
//    }
}
