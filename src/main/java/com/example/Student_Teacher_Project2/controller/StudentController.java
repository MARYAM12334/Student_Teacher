package com.example.Student_Teacher_Project2.controller;

import com.example.Student_Teacher_Project2.model.Student;
import com.example.Student_Teacher_Project2.model.Teacher;
import com.example.Student_Teacher_Project2.service.StudentService;
import com.example.Student_Teacher_Project2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller

public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/ListStudent")
        public String listStudent(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "listStudent";
    }
    @GetMapping("/addStudentPage")
    public String getaddStudentPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student,@RequestParam List<Long> teacherIds) {
        List<Teacher> teachers = teacherService.getAllTeachers()
                .stream()
                .filter(teacher -> teacherIds.contains(teacher.getId()))
                .collect(Collectors.toList());
        student.setTeachers(teachers);

        studentService.addStudent(student);
        return "addStudent";
    }

//    @PostMapping("/addStudent")
//    public String addStudent(@ModelAttribute("student") Student student) {
//        studentService.addStudent(student);
//        return "addStudent";
//    }

}
