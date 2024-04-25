package com.company.careerconnectapp.service;

import com.company.careerconnectapp.dto.ApplyPostDto;
import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseEntity<?> createDetails(ProfileDTO profileDTO);
    ResponseEntity<?> createAdditionalDetails(ProfileDTO profileDTO);
    ResponseEntity<?> updatePersonalDetails(ProfileDTO profileDto);
    ResponseEntity<?> updateAdditionalDetails(ProfileDTO profileDto);
    public List<User> findAllUsers();
    User validateUSer(HttpServletRequest request);
    ResponseEntity<?> apply(ApplyPostDto applyPostDto);

}
