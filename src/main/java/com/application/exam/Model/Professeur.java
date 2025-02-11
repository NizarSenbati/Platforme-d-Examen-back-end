package com.application.exam.Model;

import com.application.exam.security.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends User{

    @Column(unique = true)
    private int code;

    private String Departement;

    @OneToMany(mappedBy = "professeur")
    private List<ModuleElement> modules;

    @PrePersist
    public void prePersist() {
        setRole(Role.PROFESSEUR);
    }

    public List<ModuleElement> addModules(List<ModuleElement> modules){
        this.modules.addAll(modules);
        modules.forEach(e -> e.setProfesseur(this));
        return this.modules;
    }

}
