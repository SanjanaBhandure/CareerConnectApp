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

    @PostMapping("/createPersonalDetails")
    public ResponseEntity<?> addPersonalInfo(@Validated @RequestBody ProfileDTO profileDTO) {
        return userService.createDetails(profileDTO);
    }

    @PostMapping("/createAdditionalDetails")
    public ResponseEntity<?> addAdditionalInfo(@Validated @RequestBody ProfileDTO profileDTO) {
        return userService.createAdditionalDetails(profileDTO);
    }

    @PostMapping("/updatePersonalDetails")
    public ResponseEntity<?> updatePersonalDetails(@Validated @RequestBody ProfileDTO profileDTO) {
        return userService.updatePersonalDetails(profileDTO);
    }

    @PostMapping("/updateAdditionalDetails")
    public ResponseEntity<?> updateAdditionalDetails(@Validated @RequestBody ProfileDTO profileDTO) {
        return userService.updateAdditionalDetails(profileDTO);
    }

}
