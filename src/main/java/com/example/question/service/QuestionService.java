package com.example.question.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.question.dto.QuestionDTO;
import com.example.question.model.Question;
import com.example.question.repo.QuestionRepo;

@Service
@Transactional
public class QuestionService {

    @Autowired 
    private QuestionRepo questionRepo;

    @Autowired
    private ModelMapper modelMapper;

    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        questionRepo.save(modelMapper.map(questionDTO, Question.class));
        return questionDTO;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questionsList = questionRepo.findAll();
        return modelMapper.map(questionsList, new TypeToken<List<QuestionDTO>>(){}.getType());
    }

    public QuestionDTO updateQuestiont(String id, QuestionDTO questionDTO) {
        // Use userId instead of id
        Question existingQuestion = questionRepo.findById(id)
           .orElseThrow(() -> new RuntimeException("Assesment not found"));

        // Assuming you want to map the new data to the existing assessment
        modelMapper.map(questionDTO, existingQuestion); // Update existing model with new data
        Question updatedQuestion = questionRepo.save(existingQuestion); // Save the updated model

        return modelMapper.map(updatedQuestion, QuestionDTO.class); // Return the updated DTO
    }

    public String deleteQuestion(String id) {
        questionRepo.deleteById(id);
        return "Question deleted successfully";
    }

    public QuestionDTO getQuestion(String id) {
        Question question = questionRepo.geQuestionById(id);
        return modelMapper.map(question, QuestionDTO.class); // Return the mapped DTO
    }

}
