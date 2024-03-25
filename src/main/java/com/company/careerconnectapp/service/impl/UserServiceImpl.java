package com.company.careerconnectapp.service.impl;

import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.dto.ResponseDto;
import com.company.careerconnectapp.service.UserService;
import com.company.careerconnectapp.util.AppConstants;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AppConstants appConstants;

    public UserServiceImpl(AppConstants appConstants) {
        this.appConstants = appConstants;
    }

    public ResponseEntity<?> createDetails(ProfileDTO profileDTO) {
        JSONObject response = new JSONObject();


        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, response.toMap()));    }


}
