package com.example.diagnostique;
import jakarta.persistence.*;



@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    // Constructeurs, getters et setters

    public Question() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
