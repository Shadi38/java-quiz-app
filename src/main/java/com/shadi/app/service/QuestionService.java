package com.shadi.app.service;

import com.shadi.app.model.Question;
import com.shadi.app.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @service is exactly like @component,but we chose @service because we use service class
@Service
public class QuestionService {
@Autowired
QuestionDao questionDao;
//  we should return list of object from question class(we can say rows in our table)
//    public List<Question> getAllQuestions() {
//        with findAll() we have a list of our questions
//        return questionDao.findAll();
//    }

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            List<Question> questions = questionDao.findAll(); //find the data is the same as get the data meaning in JPA
            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 - No content
            }
            System.out.println("Fetched Questions: " + questions);
            return new ResponseEntity<>(questions, HttpStatus.OK); // 200 - OK
        } catch (Exception e) {
            e.printStackTrace();
        }
            // if something went wrong ,it returns an empty array (new ArrayList<>() and INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 - Server error
    }

//    public List<Question> getQuestionsByCategory(String category) {
//        return questionDao.findByCategory(category);
//    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question); //save is the same as add meaning in JPA
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }
}
