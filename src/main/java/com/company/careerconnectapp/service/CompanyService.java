package com.company.careerconnectapp.service;

import com.company.careerconnectapp.dto.CompanyDto;
import com.company.careerconnectapp.dto.FetchCompanyListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    ResponseEntity<?> createPost(CompanyDto companyDto);
    ResponseEntity<?> updatePost(CompanyDto companyDto);
    ResponseEntity<?> fetchData(Long id);
}
