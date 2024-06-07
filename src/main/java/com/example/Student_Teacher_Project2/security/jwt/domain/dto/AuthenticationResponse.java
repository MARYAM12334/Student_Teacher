package com.example.Student_Teacher_Project2.security.jwt.domain.dto;

import lombok.Data;

@Data

public class AuthenticationResponse {
    private final String jwt;
}