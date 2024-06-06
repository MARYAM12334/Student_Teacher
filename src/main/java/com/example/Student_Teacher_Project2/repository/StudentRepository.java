package com.example.Student_Teacher_Project2.repository;

import com.example.Student_Teacher_Project2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
