package com.company.careerconnectapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {
    Long id;
    String companyName;
    String experience;
    String profile;
    String skills;
    String description;
    Long hrId;
}
