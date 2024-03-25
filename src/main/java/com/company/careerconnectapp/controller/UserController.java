package com.company.careerconnectapp.controller;

import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/careerConnect/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addPersonalInfo(@Validated @RequestBody ProfileDTO profileDTO) {
        return userService.createDetails(profileDTO);
    }
}
