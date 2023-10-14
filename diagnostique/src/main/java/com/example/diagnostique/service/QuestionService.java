package com.example.diagnostique.service;

import com.example.diagnostique.Category;
import com.example.diagnostique.Question;
import com.example.diagnostique.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setText(updatedQuestion.getText());
            return questionRepository.save(existingQuestion);
        } else {
            return null; // Gérer l'erreur ici
        }
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
    public List<Question> getQuestionsByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }
}
