package com.application.exam.Service;

import com.application.exam.Model.ModuleElement;
import com.application.exam.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Get all modules
    public List<ModuleElement> getAll() {
        return this.moduleRepository.findAll();
    }

    // Get a module by ID
    public Optional<ModuleElement> getById(int id) {
        return this.moduleRepository.findById(id);
    }

    // Add a new module
    public ModuleElement saveModule(ModuleElement module) {
        return this.moduleRepository.save(module);
    }

    // Update an existing module
    public ModuleElement updateModule(int id, ModuleElement updatedModule) {
        return this.moduleRepository.findById(id)
                .map(existingModule -> {
                    existingModule.setNom(updatedModule.getNom());
                    existingModule.setProfesseur(updatedModule.getProfesseur());
                    existingModule.setEtudiants(updatedModule.getEtudiants());
                    existingModule.setExams(updatedModule.getExams());
                    return moduleRepository.save(existingModule);
                })
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }

    // Delete a module by ID
    public void deleteModule(int id) {
        this.moduleRepository.deleteById(id);
    }
}

