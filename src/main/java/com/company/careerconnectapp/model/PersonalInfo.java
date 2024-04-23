package com.company.careerconnectapp.model;

import com.company.careerconnectapp.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "personal_info")
public class PersonalInfo {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
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
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "additional_info_id", referencedColumnName = "reference_id")
    private AdditionalInfo additionalInfo;

    public PersonalInfo(ProfileDTO profileDTO) {
        this.fullName = profileDTO.getFullName();
        this.contactInfo = profileDTO.getContactInfo();
        this.location = profileDTO.getLocation();
        this.experience = profileDTO.getExperience();
        this.employmentType = profileDTO.getEmploymentType();
        this.companyName = profileDTO.getCompanyName();
        this.companyLocation = profileDTO.getCompanyLocation();
        this.locationType = profileDTO.getLocationType();
        this.currentlyWorkingFlag = profileDTO.getCurrentlyWorkingFlag();
        this.startDate = profileDTO.getStartDate();
        this.endDate = profileDTO.getEndDate();
        this.industryType = profileDTO.getIndustryType();
        this.profileHeadline = profileDTO.getProfileHeadline();
        this.skills = profileDTO.getSkills();
        this.noticePeriod = profileDTO.getNoticePeriod();
        this.currentPackage = profileDTO.getCurrentPackage();
        this.education = profileDTO.getEducation();
        this.collegeName = profileDTO.getCollegeName();
        this.academicInstitute = profileDTO.getAcademicInstitute();
        this.degree = profileDTO.getDegree();
        this.fieldOfStudy = profileDTO.getFieldOfStudy();
        this.startYear = profileDTO.getStartYear();
        this.endYear = profileDTO.getEndYear();
        this.email = profileDTO.getEmail();
    }

    public void update(ProfileDTO profileDTO) {
        this.fullName = profileDTO.getFullName();
        this.contactInfo = profileDTO.getContactInfo();
        this.location = profileDTO.getLocation();
        this.experience = profileDTO.getExperience();
        this.employmentType = profileDTO.getEmploymentType();
        this.companyName = profileDTO.getCompanyName();
        this.companyLocation = profileDTO.getCompanyLocation();
        this.locationType = profileDTO.getLocationType();
        this.currentlyWorkingFlag = profileDTO.getCurrentlyWorkingFlag();
        this.startDate = profileDTO.getStartDate();
        this.endDate = profileDTO.getEndDate();
        this.industryType = profileDTO.getIndustryType();
        this.profileHeadline = profileDTO.getProfileHeadline();
        this.skills = profileDTO.getSkills();
        this.noticePeriod = profileDTO.getNoticePeriod();
        this.currentPackage = profileDTO.getCurrentPackage();
        this.education = profileDTO.getEducation();
        this.collegeName = profileDTO.getCollegeName();
        this.academicInstitute = profileDTO.getAcademicInstitute();
        this.degree = profileDTO.getDegree();
        this.fieldOfStudy = profileDTO.getFieldOfStudy();
        this.startYear = profileDTO.getStartYear();
        this.endYear = profileDTO.getEndYear();
        this.email = profileDTO.getEmail();
    }
}
