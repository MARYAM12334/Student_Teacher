package com.example.Student_Teacher_Project2.service;


import com.example.Student_Teacher_Project2.model.Teacher;
import com.example.Student_Teacher_Project2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
