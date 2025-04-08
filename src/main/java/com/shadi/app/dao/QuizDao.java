package com.shadi.app.dao;

import com.shadi.app.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
//in below, JpaRepository gets two thing: 1-name of the table 2-name of primary key
public interface QuizDao extends JpaRepository<Quiz, Integer>{
}
