package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class categorie {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String title;
         private int score;



    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @ManyToMany
        private List<Question> questions;



    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public int getScore(int score) {
            return score;
        }
    }


