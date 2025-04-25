package com.example.question.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.question.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, String> {
     
    @Query(value = "SELECT * FROM question WHERE id = ?1", nativeQuery = true)
    Question geQuestionById(String id);

    
    Optional<Question> findById(String id);
}
