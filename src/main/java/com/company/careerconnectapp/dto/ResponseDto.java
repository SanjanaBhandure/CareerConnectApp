package com.company.careerconnectapp.dto;

import lombok.Data;

@Data
public class ResponseDto {
    String message;
    Object data;
    String code;
}
