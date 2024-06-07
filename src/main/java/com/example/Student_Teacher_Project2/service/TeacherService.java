package com.example.Student_Teacher_Project2.service;


import com.example.Student_Teacher_Project2.model.Teacher;
import com.example.Student_Teacher_Project2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    // Update operation
    public Teacher updateTeacher(Long id, Teacher newTeacher) {
        Optional<Teacher> existingTeacherOptional = teacherRepository.findById(id);
        if (existingTeacherOptional.isPresent()) {
            Teacher existingTeacher = existingTeacherOptional.get();
            // Update the properties of existingTeacher with newTeacher
            existingTeacher.setName(newTeacher.getName());
            // Update other properties as needed
            return teacherRepository.save(existingTeacher);
        } else {
            // Handle error if teacher with given id is not found
            return null;
        }
    }

    // Delete operation
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
