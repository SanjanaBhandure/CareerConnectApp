package com.company.careerconnectapp.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;

@Getter
@Setter
public class ProfileDTO {
    private String fullName;
    private String contactInfo;
    private String location;
    private Integer experience;
    private String employmentType;
    private String companyName;
    private String companyLocation;
    private String locationType;
    private String currentlyWorkingFlag;
    private String startDate;
    private String endDate;
    private String industryType;
    private String profileHeadline;
    private String skills;
    private String noticePeriod;
    private String currentPackage;
    private String education;
    private String collegeName;
    private String academicInstitute;
    private String degree;
    private String fieldOfStudy;
    private String startYear;
    private String endYear;
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
    @Email
    private String email;

}
