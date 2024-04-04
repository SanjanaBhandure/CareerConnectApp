package com.company.careerconnectapp.model;

import com.company.careerconnectapp.dto.CompanyDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "company_posts")
public class CompanyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String profile;
    private String skills;
    private String experience;
    private String description;

    private String userId;

    public CompanyDetails(CompanyDto companyDto) {
        this.companyName = companyDto.getCompanyName();
        this.profile = companyDto.getProfile();
        this.skills = companyDto.getSkills();
        this.experience = companyDto.getExperience();
        this.description = companyDto.getDescription();
    }

    public void updateCompanyDetails(CompanyDto companyDto) {
        this.companyName = companyDto.getCompanyName();
        this.profile = companyDto.getProfile();
        this.skills = companyDto.getSkills();
        this.experience = companyDto.getExperience();
        this.description = companyDto.getDescription();
    }
}
