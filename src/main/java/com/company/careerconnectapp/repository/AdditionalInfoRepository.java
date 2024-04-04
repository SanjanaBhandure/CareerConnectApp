package com.company.careerconnectapp.repository;

import com.company.careerconnectapp.model.AdditionalInfo;
import org.springframework.data.repository.CrudRepository;

public interface AdditionalInfoRepository extends CrudRepository<AdditionalInfo, Long> {
    AdditionalInfo findDistinctByReferenceId(Long id);
}
