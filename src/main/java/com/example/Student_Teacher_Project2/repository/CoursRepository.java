package com.example.Student_Teacher_Project2.repository;

import com.example.Student_Teacher_Project2.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
