package com.company.careerconnectapp.controller;

import com.company.careerconnectapp.dto.CompanyDto;
import com.company.careerconnectapp.model.Role;
import com.company.careerconnectapp.model.User;
import com.company.careerconnectapp.service.CompanyService;
import com.company.careerconnectapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/careerConnect/company")
public class CompanyController {

    private final CompanyService companyService;
    private final UserService userService;


    public CompanyController(CompanyService companyService, UserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<?> createPosts(@Validated @RequestBody CompanyDto companyDto, HttpServletRequest request) {
        User user = userService.validateUSer(request);
        if (user != null && user.getRole().equals(Role.HR)) {
            return companyService.createPost(companyDto);
        }
        return ResponseEntity.status(401).body("UnAuthorised");
    }

    @PostMapping("/updatePost")
    public ResponseEntity<?> updatePosts(@Validated @RequestBody CompanyDto companyDto, HttpServletRequest request) {
        User user = userService.validateUSer(request);
        if (user != null && user.getRole().equals(Role.HR)) {
            return companyService.updatePost(companyDto);
        }
        return ResponseEntity.status(401).body("UnAuthorised");
    }

}
