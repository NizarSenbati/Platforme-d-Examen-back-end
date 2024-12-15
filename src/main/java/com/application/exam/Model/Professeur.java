package com.application.exam.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private int code;

    private String fullName;

    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    private List<ModuleElement> modules;


    public Professeur(int id, int code, String fullName) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<ModuleElement> getModules() {
        return modules;
    }
    public void setModules(List<ModuleElement> modules) {
        this.modules = modules;
    }
}
