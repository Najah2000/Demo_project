package com.example.demo.service;

import com.example.demo.model.Question;
import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.QuizDao;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.quiz;
import com.example.demo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }



    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getOption5());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }


    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        quiz quiz = quizDao.findById(id).get();

        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getOption1())) {
                right += 5;
            }else if(response.getResponse().equals(questions.get(i).getOption2())) {
                right += 4;

            }else if(response.getResponse().equals(questions.get(i).getOption3())) {
                right += 3;

            }else if(response.getResponse().equals(questions.get(i).getOption4())) {
                right += 2;

            }else if(response.getResponse().equals(questions.get(i).getOption5())) {
                right += 1;

            }

            i++;
        }
        // Mettez à jour le score du quiz avec la valeur "right"
        quiz.setScore(right);

        // Enregistrez les modifications dans la base de données
        quizDao.save(quiz);

        return new ResponseEntity<>(right , HttpStatus.OK);
    }

    public List<Integer> getScoresForAllQuizzes() {
        List<quiz> allQuizzes = quizDao.findAll();
        List<Integer> quizScores = new ArrayList<>();

        for (quiz quiz : allQuizzes) {
            quizScores.add(quiz.getScore());
        }

        return quizScores;
    }
    public int getTotalScores() {
        Iterable<quiz> allQuizzes = quizDao.findAll();
        int totalScores = 0;

        for (quiz quiz : allQuizzes) {
            totalScores += quiz.getScore();
        }

        return totalScores;
    }






        }





