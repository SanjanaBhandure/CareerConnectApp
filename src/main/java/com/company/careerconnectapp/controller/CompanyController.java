package com.company.careerconnectapp.controller;

import com.company.careerconnectapp.dto.CompanyDto;
import com.company.careerconnectapp.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/careerConnect/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<?> createPosts(@Validated @RequestBody CompanyDto companyDto) {
        return companyService.createPost(companyDto);
    }

    @PostMapping("/updatePost")
    public ResponseEntity<?> updatePosts(@Validated @RequestBody CompanyDto companyDto) {
        return companyService.updatePost(companyDto);
    }

}
