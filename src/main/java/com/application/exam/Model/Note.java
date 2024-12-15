package com.application.exam.Model;

import jakarta.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private Float note;


    public Note() {}


    public Note(Etudiant etudiant, Exam exam, Float note) {
        this.etudiant = etudiant;
        this.exam = exam;
        this.note = note;
    }


    public int getIdEtd() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Float getNote() {
        return note;
    }
    public void setNote(Float note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", etudiant=" + etudiant +
                ", exam=" + exam +
                ", note=" + note +
                '}';
    }
}
