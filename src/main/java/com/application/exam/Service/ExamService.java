package com.application.exam.Service;

import com.application.exam.Model.Exam;
import com.application.exam.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    // Get all exams
    public List<Exam> getAll() {
        return this.examRepository.findAll();
    }

    // Get an exam by ID
    public Optional<Exam> getById(int id) {
        return this.examRepository.findById(id);
    }

    // Add a new exam
    public Exam saveExam(Exam exam) {
        return this.examRepository.save(exam);
    }

    // Update an existing exam
    public Exam updateExam(int id, Exam updatedExam) {
        return this.examRepository.findById(id)
                .map(existingExam -> {
                    existingExam.setTitre(updatedExam.getTitre());
                    existingExam.setDuree(updatedExam.getDuree());
                    existingExam.setNotes(updatedExam.getNotes());
                    existingExam.setModule(updatedExam.getModule());
                    return examRepository.save(existingExam);
                })
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + id));
    }

    // Delete an exam by ID
    public void deleteExam(int id) {
        this.examRepository.deleteById(id);
    }
}

