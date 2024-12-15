package com.application.exam.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    private String difficulte;

    private String sujet;

    private String rep1;
    private String rep2;
    private String rep3;
    private String rep4;

    private int indice;

    @ManyToMany
    @JoinTable(
            name = "question_exam",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
    private List<Exam> exams;


    public Question(int id, String question, int indice, String sujet, String difficulte){
        this.id = id;
        this.question = question;
        this.indice = indice;
        this.difficulte = difficulte;
        this.sujet = sujet;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSujet() {
        return sujet;
    }
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDifficulte() {
        return difficulte;
    }
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getRep1() {
        return rep1;
    }
    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }
    public String getRep2() {
        return rep2;
    }

    public String getRep4() {
        return rep4;
    }
    public void setRep4(String rep4) {
        this.rep4 = rep4;
    }

    public String getRep3() {
        return rep3;
    }
    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

}
