package com.application.exam.Controller;

import com.application.exam.Model.ModuleElement;
import com.application.exam.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Get all modules
    @GetMapping
    public ResponseEntity<List<ModuleElement>> getAllModules() {
        List<ModuleElement> modules = moduleService.getAll();
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }

    // Add a new module
    @PostMapping
    public ResponseEntity<ModuleElement> addModule(@RequestBody ModuleElement module) {
        ModuleElement savedModule = moduleService.saveModule(module);
        return new ResponseEntity<>(savedModule, HttpStatus.CREATED);
    }

    // Get a specific module by ID
    @GetMapping("/{id}")
    public ResponseEntity<ModuleElement> getModuleById(@PathVariable int id) {
        Optional<ModuleElement> module = moduleService.getById(id);
        return module.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a module by ID
    @PutMapping("/{id}")
    public ResponseEntity<ModuleElement> updateModule(@PathVariable int id, @RequestBody ModuleElement module) {
        try {
            ModuleElement updatedModule = moduleService.updateModule(id, module);
            return new ResponseEntity<>(updatedModule, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a module by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable int id) {
        try {
            moduleService.deleteModule(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
