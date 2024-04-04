package com.company.careerconnectapp.service.impl;

import com.company.careerconnectapp.dto.CompanyDto;
import com.company.careerconnectapp.dto.ResponseDto;
import com.company.careerconnectapp.model.CompanyDetails;
import com.company.careerconnectapp.repository.CompanyDetailRepository;
import com.company.careerconnectapp.service.CompanyService;
import com.company.careerconnectapp.util.AppConstants;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final AppConstants appConstants;
    private final CompanyDetailRepository companyDetailRepository;

    public CompanyServiceImpl(AppConstants appConstants, CompanyDetailRepository companyDetailRepository) {
        this.appConstants = appConstants;
        this.companyDetailRepository = companyDetailRepository;
    }

    public ResponseEntity<?> createPost(CompanyDto companyDto) {
        JSONObject response = new JSONObject();
        CompanyDetails companyDetails = new CompanyDetails(companyDto);
        companyDetailRepository.save(companyDetails);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> updatePost(CompanyDto companyDto) {
        JSONObject response = new JSONObject();
        CompanyDetails companyDetails = new CompanyDetails(companyDto);
        companyDetailRepository.save(companyDetails);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }
}
