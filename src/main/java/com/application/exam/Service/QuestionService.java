package com.application.exam.Service;

import com.application.exam.Model.Question;
import com.application.exam.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepo;

    public Question saveQuestion(Question newQ){
        return this.questionRepo.save(newQ);
    }

    public Question updateQuestion(Question newQ) {
        return questionRepo.findById(newQ.getId())
                .map(existingQ -> {
                    existingQ.setQuestion(newQ.getQuestion());
                    existingQ.setRep1(newQ.getRep1());
                    existingQ.setRep2(newQ.getRep2());
                    existingQ.setRep3(newQ.getRep3());
                    existingQ.setRep4(newQ.getRep4());
                    existingQ.setIndice(newQ.getIndice());
                    existingQ.setDifficulte(newQ.getDifficulte());
                    existingQ.setSujet(newQ.getSujet());
                    return questionRepo.save(existingQ);
                }).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public List<Question> getAll(){
        return questionRepo.findAll();
    }

    public Question getOne(int id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    public void deleteQuestion(int id){
        this.questionRepo.deleteById(id);
    }

}
