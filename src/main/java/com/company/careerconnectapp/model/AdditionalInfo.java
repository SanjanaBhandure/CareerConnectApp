package com.company.careerconnectapp.model;

import com.company.careerconnectapp.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "additional_info")
public class AdditionalInfo {
    @Id
    @Column(name = "reference_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long referenceId;
    private String professionalSummary;
    private String achievements;
    private String languages;
    private String refer;
    private String hobbies;
    private String interests;
    private String portfolio;
    private String socialMediaProfile;
    private String desiredJobProfile;
    private String salaryRange;
    private String availability;
    private String visibility;
    private String jobLookingFlag;

    @OneToOne(mappedBy = "additionalInfo")
    private PersonalInfo personalInfo;

    public AdditionalInfo(ProfileDTO profileDTO) {
        this.professionalSummary = profileDTO.getProfessionalSummary();
        this.achievements = profileDTO.getAchievements();
        this.languages = profileDTO.getLanguage();
        this.refer = profileDTO.getReferences();
        this.hobbies = profileDTO.getHobbies();
        this.interests = profileDTO.getInterests();
        this.portfolio = profileDTO.getPortfolio();
        this.socialMediaProfile = profileDTO.getSocialMediaProfile();
        this.desiredJobProfile = profileDTO.getDesiredJobProfile();
        this.salaryRange = profileDTO.getSalaryRange();
        this.availability = profileDTO.getAvailability();
        this.visibility = profileDTO.getVisibility();
        this.jobLookingFlag = profileDTO.getJobLookingFlag();
    }

    public void update(ProfileDTO profileDTO) {
        this.professionalSummary = profileDTO.getProfessionalSummary();
        this.achievements = profileDTO.getAchievements();
        this.languages = profileDTO.getLanguage();
        this.refer = profileDTO.getReferences();
        this.hobbies = profileDTO.getHobbies();
        this.interests = profileDTO.getInterests();
        this.portfolio = profileDTO.getPortfolio();
        this.socialMediaProfile = profileDTO.getSocialMediaProfile();
        this.desiredJobProfile = profileDTO.getDesiredJobProfile();
        this.salaryRange = profileDTO.getSalaryRange();
        this.availability = profileDTO.getAvailability();
        this.visibility = profileDTO.getVisibility();
        this.jobLookingFlag = profileDTO.getJobLookingFlag();
    }
}
