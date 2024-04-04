package com.company.careerconnectapp.repository;

import com.company.careerconnectapp.model.CompanyDetails;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDetailRepository extends CrudRepository<CompanyDetails, Long> {
    CompanyDetails findDistinctById(Long id);
}
