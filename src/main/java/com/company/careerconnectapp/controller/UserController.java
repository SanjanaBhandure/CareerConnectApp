package com.company.careerconnectapp.controller;

import com.company.careerconnectapp.dto.ProfileDTO;
import com.company.careerconnectapp.dto.ResponseDto;
import com.company.careerconnectapp.service.UserService;
import com.company.careerconnectapp.util.AppConstants;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/careerConnect/user")
public class UserController {

    private final AppConstants appConstants;
    private final UserService userService;


    public UserController(AppConstants appConstants, UserService userService) {
        this.appConstants = appConstants;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addPersonalInfo(@RequestBody ProfileDTO profileDTO) {

        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK.value(), appConstants.SUCCESSFUL_RESPONSE_MESSAGE, new JSONObject().put("message", "Hello Sanjana").toMap()));
    }
}
