package com.application.exam.Controller;

import com.application.exam.Model.Exam;
import com.application.exam.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    // Get all exams
    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAll();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    // Add a new exam
    @PostMapping
    public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
        Exam savedExam = examService.saveExam(exam);
        return new ResponseEntity<>(savedExam, HttpStatus.CREATED);
    }

    // Get a specific exam by ID
    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable int id) {
        Optional<Exam> exam = examService.getById(id);
        return exam.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable int id, @RequestBody Exam exam) {
        try {
            Exam updatedExam = examService.updateExam(id, exam);
            return new ResponseEntity<>(updatedExam, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an exam by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable int id) {
        try {
            examService.deleteExam(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
