package com.example.Student_Teacher_Project2.security.jwt.controller;

import com.example.Student_Teacher_Project2.model.Student;
import com.example.Student_Teacher_Project2.security.jwt.service.MyUserDetailsService;
import com.example.Student_Teacher_Project2.security.jwt.util.JwtUtil;
import com.example.Student_Teacher_Project2.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            model.addAttribute("error", "Incorrect username or password");
            return "login";
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        log.info("User details: " + userDetails.toString());
        final String jwt = jwtUtil.generateToken(userDetails);


        model.addAttribute("token", jwt);
        model.addAttribute("username", username);
//        List<Student> students = studentService.getAllStudents();
//        model.addAttribute("students", students);

        return "secure";
        //return "listStudent";

    }
}
