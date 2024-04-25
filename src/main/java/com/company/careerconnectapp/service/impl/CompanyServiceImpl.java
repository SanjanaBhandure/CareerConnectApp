package com.company.careerconnectapp.service.impl;

import com.company.careerconnectapp.dto.CompanyDto;
import com.company.careerconnectapp.dto.FetchCompanyListDto;
import com.company.careerconnectapp.dto.ResponseDto;
import com.company.careerconnectapp.model.CompanyDetails;
import com.company.careerconnectapp.model.PersonalInfo;
import com.company.careerconnectapp.repository.CompanyDetailRepository;
import com.company.careerconnectapp.repository.PersonalInfoRepository;
import com.company.careerconnectapp.service.CompanyService;
import com.company.careerconnectapp.util.AppConstants;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final AppConstants appConstants;
    private final CompanyDetailRepository companyDetailRepository;
    private final PersonalInfoRepository personalInfoRepository;

    public CompanyServiceImpl(AppConstants appConstants, CompanyDetailRepository companyDetailRepository, PersonalInfoRepository personalInfoRepository) {
        this.appConstants = appConstants;
        this.companyDetailRepository = companyDetailRepository;
        this.personalInfoRepository = personalInfoRepository;
    }

    public ResponseEntity<?> createPost(CompanyDto companyDto) {
        JSONObject response = new JSONObject();
        CompanyDetails companyDetails = new CompanyDetails(companyDto);
        companyDetailRepository.save(companyDetails);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> updatePost(CompanyDto companyDto) {
        JSONObject response = new JSONObject();
        CompanyDetails companyDetails = companyDetailRepository.findDistinctById(companyDto.getId());
        companyDetails.updateCompanyDetails(companyDto);
        companyDetailRepository.save(companyDetails);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> fetchData(Long id) {
        if (id == null) {
            return ResponseEntity.ok(companyDetailRepository.findAll());
        } else {
            try {
                return ResponseEntity.ok(companyDetailRepository.findAllByOwnerId(id));
            } catch (Exception e) {
               Optional<PersonalInfo> personalData = personalInfoRepository.findById(id);
               if (personalData.isPresent()) {
                   return ResponseEntity.ok(personalData.get().getAppliedCompanies());
               } else {
                   return ResponseEntity.ok("");
               }
            }
        }
    }

}
