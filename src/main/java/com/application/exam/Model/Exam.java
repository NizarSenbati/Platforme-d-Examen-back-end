package com.application.exam.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;

    private int duree;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleElement module;



    public Exam() {}


    public Exam(String titre, int duree, ModuleElement module) {
        this.titre = titre;
        this.duree = duree;
        this.module = module;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public ModuleElement getModule() {
        return module;
    }

    public void setModule(ModuleElement module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", duree=" + duree +
                ", module=" + module +
                '}';
    }
}

