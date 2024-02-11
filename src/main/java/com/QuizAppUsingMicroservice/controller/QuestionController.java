package com.QuizAppUsingMicroservice.controller;


import com.QuizAppUsingMicroservice.model.Question;
import com.QuizAppUsingMicroservice.model.QuestionWrapper;
import com.QuizAppUsingMicroservice.model.Response;
import com.QuizAppUsingMicroservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{topic}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    //generate
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,
                                                                @RequestParam int numQues)
    {
        return questionService.getQuestionsForQuiz(categoryName,numQues);
    }
    //getQuestions (questionId)
    @PostMapping("/getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionId)
    {
        return  questionService.getQuestionsFromId(questionId);
    }
    //getScore
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }
}
