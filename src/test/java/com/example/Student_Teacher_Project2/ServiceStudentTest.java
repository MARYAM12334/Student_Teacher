package com.example.Student_Teacher_Project2;

import com.example.Student_Teacher_Project2.model.Student;
import com.example.Student_Teacher_Project2.model.Teacher;
import com.example.Student_Teacher_Project2.repository.StudentRepository;
import com.example.Student_Teacher_Project2.service.StudentService;
import com.example.Student_Teacher_Project2.service.TeacherService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceStudentTest {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherService teacherService;


    @Test
    @Transactional
    public void getAllStudents(){
        List<Student> students = new ArrayList<Student>();
        students = studentService.getAllStudents();
        System.out.println(students);
        //System.out.println(students.get(0).getTeachers());
        students.forEach(student -> {
            System.out.println(student.getEmail());
            student.getTeachers().forEach(teacher -> System.out.println("\t" + teacher.getName()));
        });
    }

    @Test
    @Transactional
    public void getAllTeachers(){
        List<Teacher> students = new ArrayList<>();
        students = teacherService.getAllTeachers();
        System.out.println(students);
        //System.out.println(students.get(0).getTeachers());
    }
    @Test
    public void getAllStudents2(){
        System.out.println(studentRepository.findAll());
    }
}
