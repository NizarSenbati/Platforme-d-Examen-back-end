package com.application.exam.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private int code;

    private String fullName;

    @ManyToMany
    @JoinTable(
            name = "etudiant_module",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<ModuleElement> modules;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;


    public Etudiant(int id, int code, String fullName) {
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

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", code=" + code +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
