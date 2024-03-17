package com.company.careerconnectapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;

@Data
@ToString
@Table(name = "additionalInfoDto")
public class AdditionalInfoDto {
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

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        this.professionalSummary = professionalSummary;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getSocialMediaProfile() {
        return socialMediaProfile;
    }

    public void setSocialMediaProfile(String socialMediaProfile) {
        this.socialMediaProfile = socialMediaProfile;
    }

    public String getDesiredJobProfile() {
        return desiredJobProfile;
    }

    public void setDesiredJobProfile(String desiredJobProfile) {
        this.desiredJobProfile = desiredJobProfile;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getJobLookingFlag() {
        return jobLookingFlag;
    }

    public void setJobLookingFlag(String jobLookingFlag) {
        this.jobLookingFlag = jobLookingFlag;
    }
}
