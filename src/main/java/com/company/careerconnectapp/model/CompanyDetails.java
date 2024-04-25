package com.company.careerconnectapp.model;

import com.company.careerconnectapp.dto.CompanyDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    private Long ownerId;

    public CompanyDetails(CompanyDto companyDto) {
        this.companyName = companyDto.getCompanyName();
        this.profile = companyDto.getProfile();
        this.skills = companyDto.getSkills();
        this.experience = companyDto.getExperience();
        this.description = companyDto.getDescription();
        this.ownerId = companyDto.getHrId();
    }

    public void updateCompanyDetails(CompanyDto companyDto) {
        this.companyName = companyDto.getCompanyName();
        this.profile = companyDto.getProfile();
        this.skills = companyDto.getSkills();
        this.experience = companyDto.getExperience();
        this.description = companyDto.getDescription();
    }
}
