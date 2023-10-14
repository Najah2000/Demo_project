package com.example.demo.service;


import com.example.demo.model.Question;
import com.example.demo.dao.QuestionDao;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questiondao;
    public List<Question> getAllQuestions() {
      return   questiondao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questiondao.findByCategory(category);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(Integer id : questionIds){
            questions.add(questiondao.findById(id).get());
        }
        for (Question question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle((question.getQuestionTitle()));
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrapper.setOption5(question.getOption5());
            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right = 0;
            int i = 0;
            for(Response response : responses){
                Question question = questiondao.findById(response.getId()).get();

                if(response.getResponse().equals(question.getOption1())) {
                    right += 5;
                }else if(response.getResponse().equals(question.getOption2())) {
                    right += 4;

                }else if(response.getResponse().equals(question.getOption3())) {
                    right += 3;

                }else if(response.getResponse().equals(question.getOption4())) {
                    right += 2;

                }else if(response.getResponse().equals(question.getOption5())) {
                    right += 1;

                }

                i++;
            }
            return new ResponseEntity<>(right / getAllQuestions().size(), HttpStatus.OK);
        }

}



















