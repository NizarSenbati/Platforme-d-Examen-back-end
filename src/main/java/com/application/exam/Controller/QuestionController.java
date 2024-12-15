package com.application.exam.Controller;


import com.application.exam.Model.Question;
import com.application.exam.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Question> questions = questionService.getAll();
            if (questions.isEmpty()) {
                return new ResponseEntity<>("No questions found.", HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching questions.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody Question newQ) {
        try {
            if (newQ == null || newQ.getQuestion() == null || newQ.getQuestion().isEmpty()) {
                return new ResponseEntity<>("Invalid question data provided.", HttpStatus.BAD_REQUEST);
            }
            Question savedQuestion = questionService.saveQuestion(newQ);
            return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save question.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable int id) {
        try {
            if (id < 0) {
                return new ResponseEntity<>("ID must be a positive integer", HttpStatus.BAD_REQUEST);
            }
            Question question = questionService.getOne(id);
            if (question == null) {
                return new ResponseEntity<>("Question not found with ID: " + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching the question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
        try {
            Question updatedQuestion = questionService.updateQuestion(question);
            return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id) {
        try {
            questionService.deleteQuestion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
