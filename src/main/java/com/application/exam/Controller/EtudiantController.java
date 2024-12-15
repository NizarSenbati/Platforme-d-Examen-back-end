package com.application.exam.Controller;

import com.application.exam.Model.Etudiant;
import com.application.exam.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Get all students
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAll();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    // Get a specific student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable int id) {
        Optional<Etudiant> etudiant = etudiantService.getById(id);
        return etudiant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new student
    @PostMapping
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.saveEtudiant(etudiant);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    // Update a student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(
            @PathVariable int id,
            @RequestBody Etudiant etudiant) {
        try {
            Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiant);
            return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable int id) {
        try {
            etudiantService.deleteEtudiant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

