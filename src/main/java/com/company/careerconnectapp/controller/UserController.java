package com.company.careerconnectapp.controller;

import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/careerConnect/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createPersonalDetails")
    public ResponseEntity<?> addPersonalInfo(@Valid @RequestBody ProfileDTO profileDTO) {
        return userService.createDetails(profileDTO);
    }

    @PostMapping("/updateAdditionalDetails")
    public ResponseEntity<?> addAdditionalInfo(@Validated @RequestBody ProfileDTO profileDTO) {
        return userService.createAdditionalDetails(profileDTO);
    }
}
