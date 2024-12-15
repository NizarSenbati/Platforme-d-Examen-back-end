package com.application.exam.Service;

import com.application.exam.Model.Professeur;
import com.application.exam.Repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> getAll() {
        return this.professeurRepository.findAll();
    }

    public Optional<Professeur> getById(int id) {
        return this.professeurRepository.findById(id);
    }

    public Professeur save(Professeur professeur) {
        return this.professeurRepository.save(professeur);
    }

    public Professeur update(int id, Professeur updatedProfesseur) {
        return this.professeurRepository.findById(id)
                .map(existingProf -> {
                    existingProf.setCode(updatedProfesseur.getCode());
                    existingProf.setFullName(updatedProfesseur.getFullName());
                    existingProf.setModules(updatedProfesseur.getModules());
                    return professeurRepository.save(existingProf);
                })
                .orElseThrow(() -> new RuntimeException("Professeur not found with id: " + id));
    }


    public void delete(int id) {
        this.professeurRepository.deleteById(id);
    }
}
