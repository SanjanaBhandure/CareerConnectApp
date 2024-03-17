package com.company.careerconnectapp.dto;

import lombok.Data;

@Data
public class ResponseDto {
    String message;
    Object data;
    int code;

    public ResponseDto(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
