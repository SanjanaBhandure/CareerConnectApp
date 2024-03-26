package com.company.careerconnectapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
public class ProfileDTO {
    @NotNull
    private String fullName;
    @NotNull
    private String contactInfo;
    @NotNull
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
    @NotNull
    private String skills;
    private String noticePeriod;
    private String currentPackage;
    @NotNull
    private String education;
    @NotNull
    private String collegeName;
    private String academicInstitute;
    @NotNull
    private String degree;
    private String fieldOfStudy;
    @NotNull
    private String startYear;
    @NotNull
    private String endYear;
    private String professionalSummary;
    private String achievements;
    @NotNull
    private String language;
    private String references;
    private String hobbies;
    private String interests;
    private String portfolio;
    private String socialMediaProfile;
    private String desiredJobProfile;
    @NotNull
    private String salaryRange;
    @NotNull
    private String availability;
    @NotNull
    private String visibility;
    @NotNull
    private String jobLookingFlag;
    @Email
    private String email;

}
