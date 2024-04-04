package com.company.careerconnectapp.service.impl;

import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.dto.ResponseDto;
import com.company.careerconnectapp.model.AdditionalInfo;
import com.company.careerconnectapp.model.PersonalInfo;
import com.company.careerconnectapp.repository.AdditionalInfoRepository;
import com.company.careerconnectapp.repository.PersonalInfoRepository;
import com.company.careerconnectapp.service.UserService;
import com.company.careerconnectapp.util.AppConstants;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AppConstants appConstants;
    private final PersonalInfoRepository personalInfoRepository;
    private final AdditionalInfoRepository additionalInfoRepository;

    public UserServiceImpl(AppConstants appConstants, PersonalInfoRepository personalInfoRepository, AdditionalInfoRepository additionalInfoRepository) {
        this.appConstants = appConstants;
        this.personalInfoRepository = personalInfoRepository;
        this.additionalInfoRepository = additionalInfoRepository;
    }

    public ResponseEntity<?> createDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        PersonalInfo personalInfo = new PersonalInfo(profileDTO);
        personalInfoRepository.save(personalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> createAdditionalDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        AdditionalInfo additionalInfo = new AdditionalInfo(profileDTO);
        additionalInfoRepository.save(additionalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> updatePersonalDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        PersonalInfo personalInfo = new PersonalInfo(profileDTO);
        personalInfoRepository.save(personalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> updateAdditionalDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        AdditionalInfo additionalInfo = new AdditionalInfo(profileDTO);
        additionalInfoRepository.save(additionalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

}
