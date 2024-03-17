package com.company.careerconnectapp.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
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
}
