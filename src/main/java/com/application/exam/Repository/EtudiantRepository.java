package com.application.exam.Repository;

import com.application.exam.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    Optional<Etudiant> findByEmail(String email);

    default int getLastAppoge(){
        return findAll().stream().mapToInt(Etudiant::getAppoge).max().orElse(0);
    };
}
