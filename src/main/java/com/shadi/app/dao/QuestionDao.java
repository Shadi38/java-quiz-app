package com.shadi.app.dao;

import com.shadi.app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository comes from data-jpl package that we entered to pom.xml. with data-jpl we can do below:
// instead of creating QuestionDao class, we create QuestionDao interface and extend JpaRepository.
// with above approach, data-jpl will handle all things(fetching data from database and saving data)
//in JpaRepository<> we have to mention 2 things :
// 1- what type of table you are working with.(class name which the table is there and is mapped to the class)
// 2- what is the type of primary key.

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    //data-jpl is smart and realize that the category is the column of table and retrieves  all java question
     List<Question> findByCategory(String category);

     //we need to choose questions which the number of questions is equal numQ (for example numQ=5) and category of the questions is equal to category(for example category=java)
    //we use @Query(comes from data jpl) if we want to execute particular query for method --> @Query(value = "", nativeQuery = true)
    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
     List<Question> findRandomQuestionsByCategory(@org.springframework.data.repository.query.Param("category") String category,
                                                  @org.springframework.data.repository.query.Param("numQ") int numQ);
}
