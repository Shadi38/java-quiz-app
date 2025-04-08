package com.shadi.app.dao;

import com.shadi.app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository comes from data-jpl package that we entered to pom.xml. with data-jpl we can do below:
// instead of creating QuestionDao class, we create QuestionDao interface and extend JpaRepository.
// with above approach, data-jpl will handle all things(fetching data from database and saving data)

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    //data-jpl is smart and realize that the category is the column of table
     List<Question> findByCategory(String category);

     //we need to choose questions which the number of questions is equal numQ (for example numQ=5) and category of the questions is equal to category(for example category=java)
     @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
     List<Question> findRandomQuestionsByCategory(@org.springframework.data.repository.query.Param("category") String category,
                                                  @org.springframework.data.repository.query.Param("numQ") int numQ);
}
