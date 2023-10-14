package com.example.demo.controller;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.Response;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {




        @Autowired
        QuizService quizService;

        @PostMapping("create")
        public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
            return quizService.createQuiz(category, numQ, title);


        }

        @GetMapping("get/{id}")
        public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
            return quizService.getQuizQuestions(id);
        }

        @PostMapping("submit/{id}")
        public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
            return quizService.calculateResult(id, responses);


        }
    @GetMapping("/all-quiz-scores")
    public ResponseEntity<List<Integer>> getScoresForAllQuizzes() {
        List<Integer> quizScores = quizService.getScoresForAllQuizzes();
        return ResponseEntity.ok(quizScores);
    }

    @GetMapping("/total-scores")
    public ResponseEntity<Integer> getTotalScores() {
        int totalScores = quizService.getTotalScores();
        return ResponseEntity.ok(totalScores);
    }

    }


