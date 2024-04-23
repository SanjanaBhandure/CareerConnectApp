package com.company.careerconnectapp.service.impl;

import com.company.careerconnectapp.config.JwtTokenProvider;
import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.dto.ResponseDto;
import com.company.careerconnectapp.exception.UserException;
import com.company.careerconnectapp.model.AdditionalInfo;
import com.company.careerconnectapp.model.PersonalInfo;
import com.company.careerconnectapp.model.Role;
import com.company.careerconnectapp.model.User;
import com.company.careerconnectapp.repository.AdditionalInfoRepository;
import com.company.careerconnectapp.repository.PersonalInfoRepository;
import com.company.careerconnectapp.repository.UserRepository;
import com.company.careerconnectapp.service.UserService;
import com.company.careerconnectapp.util.AppConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final AppConstants appConstants;
    private final PersonalInfoRepository personalInfoRepository;
    private final AdditionalInfoRepository additionalInfoRepository;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    public UserServiceImpl(AppConstants appConstants, PersonalInfoRepository personalInfoRepository, AdditionalInfoRepository additionalInfoRepository,
                           UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.appConstants = appConstants;
        this.personalInfoRepository = personalInfoRepository;
        this.additionalInfoRepository = additionalInfoRepository;
        this.userRepository=userRepository;
        this.jwtTokenProvider=jwtTokenProvider;
    }

    public ResponseEntity<?> createDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        PersonalInfo personalInfo = new PersonalInfo(profileDTO);
        personalInfoRepository.save(personalInfo);
        User user = new User();
        user.setEmail(profileDTO.getEmail());
        user.setRole(Role.valueOf(profileDTO.getRole()));
        user.setName(profileDTO.getFullName());
        user.setPassword(profileDTO.getPassword());
        userRepository.save(user);
        response.put("token", jwtTokenProvider.generateToken(user.getEmail()));
        response.put("personalInfoId", personalInfo.getPersonId());
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> createAdditionalDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        PersonalInfo personalInfo = personalInfoRepository.findDistinctByPersonId(profileDTO.getId());
        AdditionalInfo additionalInfo = new AdditionalInfo(profileDTO);
        personalInfo.setAdditionalInfo(additionalInfo);
        personalInfoRepository.save(personalInfo);
        additionalInfoRepository.save(additionalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> updatePersonalDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        PersonalInfo personalInfo = personalInfoRepository.findDistinctByPersonId(profileDTO.getId());
        personalInfo.update(profileDTO);
        personalInfoRepository.save(personalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    public ResponseEntity<?> updateAdditionalDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();
        AdditionalInfo additionalInfo = additionalInfoRepository.findDistinctByReferenceId(profileDTO.getId());
        additionalInfo.update(profileDTO);
        additionalInfoRepository.save(additionalInfo);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));
    }

    @Override
    public List<User> findAllUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public User validateUSer(HttpServletRequest request) {
        User user = userRepository.findDistinctByEmail((String) request.getAttribute("userId"));
        return user;
    }

}
