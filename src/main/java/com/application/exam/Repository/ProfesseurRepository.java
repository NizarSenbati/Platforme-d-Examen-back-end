package com.application.exam.Repository;


import com.application.exam.Model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer>  {
}
