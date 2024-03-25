package com.company.careerconnectapp.service;

import com.company.careerconnectapp.dto.ProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ResponseEntity<?> createDetails(ProfileDTO profileDTO);

}
