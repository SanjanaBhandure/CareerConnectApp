package com.company.careerconnectapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "personalDto")
public class PersonalInfo {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String personId;
    private String fullName;
    private String contactInfo;
    private String location;
    private String experience;
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

}
