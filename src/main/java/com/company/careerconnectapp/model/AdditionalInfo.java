package com.company.careerconnectapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;

@Data
@ToString
@Table(name = "additionalInfoDto")
public class AdditionalInfo {
    private String professionalSummary;
    private String achievements;
    private String language;
    private String references;
    private String hobbies;
    private String interests;
    private String portfolio;
    private String socialMediaProfile;
    private String desiredJobProfile;
    private String salaryRange;
    private String availability;
    private String visibility;
    private String jobLookingFlag;
}
