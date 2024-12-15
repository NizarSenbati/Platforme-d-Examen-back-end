package com.application.exam.Controller;

import com.application.exam.Model.Professeur;
import com.application.exam.Service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;


    @GetMapping
    public ResponseEntity<List<Professeur>> getAll() {
        List<Professeur> professeurs = professeurService.getAll();
        return new ResponseEntity<>(professeurs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getById(@PathVariable int id) {
        Optional<Professeur> professeur = professeurService.getById(id);
        return professeur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Professeur> save(@RequestBody Professeur professeur) {
        Professeur savedProfesseur = professeurService.save(professeur);
        return new ResponseEntity<>(savedProfesseur, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Professeur> update(@PathVariable int id, @RequestBody Professeur professeur) {
        try {
            Professeur updatedProfesseur = professeurService.update(id, professeur);
            return new ResponseEntity<>(updatedProfesseur, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            professeurService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
