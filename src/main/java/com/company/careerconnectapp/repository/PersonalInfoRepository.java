package com.company.careerconnectapp.repository;

import com.company.careerconnectapp.model.PersonalInfo;
import org.springframework.data.repository.CrudRepository;

public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, Long> {
    PersonalInfo findDistinctByPersonId(Long id);
}
