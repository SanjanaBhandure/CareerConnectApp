package com.company.careerconnectapp.controller;

import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.exception.UserException;
import com.company.careerconnectapp.model.Role;
import com.company.careerconnectapp.model.User;
import com.company.careerconnectapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> addPersonalInfo(@Validated @RequestBody ProfileDTO profileDTO, HttpServletRequest request) {
        User user = userService.validateUSer(request);
        if (user != null) {
            return userService.createDetails(profileDTO);
        } else {
            return ResponseEntity.status(400).body("Email is already used");
        }
    }

    @PostMapping("/createAdditionalDetails")
    public ResponseEntity<?> addAdditionalInfo(@Validated @RequestBody ProfileDTO profileDTO, HttpServletRequest request) {
        User user = userService.validateUSer(request);
        if (user != null && user.getRole().equals(Role.USER)) {
            return userService.createAdditionalDetails(profileDTO);
        }
        return ResponseEntity.status(401).body("UnAuthorised");
    }

    @PostMapping("/updatePersonalDetails")
    public ResponseEntity<?> updatePersonalDetail(@Validated @RequestBody ProfileDTO profileDTO, HttpServletRequest request) {
        User user = userService.validateUSer(request);
        if (user != null && user.getRole().equals(Role.USER)) {
            return userService.updatePersonalDetails(profileDTO);
        }
        return ResponseEntity.status(401).body("UnAuthorised");
    }

    @PostMapping("/updateAdditionalDetails")
    public ResponseEntity<?> updateAdditionalDetail(@Validated @RequestBody ProfileDTO profileDTO, HttpServletRequest request) {
        User user = userService.validateUSer(request);
        if (user != null && user.getRole().equals(Role.USER)) {
            return userService.updateAdditionalDetails(profileDTO);
        }
        return ResponseEntity.status(401).body("UnAuthorised");
    }

}
