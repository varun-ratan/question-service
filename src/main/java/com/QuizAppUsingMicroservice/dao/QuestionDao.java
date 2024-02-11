package com.QuizAppUsingMicroservice.dao;

import com.QuizAppUsingMicroservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao  extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
    @Query(value="SELECT q.id FROM question q WHERE q.category=:category order by RAND() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category,int numQ);
}
