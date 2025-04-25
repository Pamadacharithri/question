package com.example.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question.dto.QuestionDTO;
import com.example.question.service.QuestionService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

     @PostMapping("/create")
    public QuestionDTO createQuestion(@RequestBody QuestionDTO questionDTO) {
        return questionService.addQuestion(questionDTO);
    }

    @GetMapping("/")
    public List<QuestionDTO> getQuestions() {
        return questionService.getAllQuestions();
    }

    @PutMapping("/update/{id}")
    public QuestionDTO updateQuestion(@PathVariable String id, @RequestBody QuestionDTO  questionDTO) {
        return questionService.updateQuestiont(id, questionDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable String id) {
        return questionService.deleteQuestion(id);
    }

    @GetMapping("/get/{id}")
    public QuestionDTO getQuestion(@PathVariable String id) {
        return questionService.getQuestion(id);
    }

}
