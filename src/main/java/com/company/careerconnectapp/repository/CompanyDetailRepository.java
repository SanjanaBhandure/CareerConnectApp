package com.company.careerconnectapp.repository;

import com.company.careerconnectapp.model.CompanyDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyDetailRepository extends CrudRepository<CompanyDetails, Long> {
    CompanyDetails findDistinctById(Long id);
    List<CompanyDetails> findAllByOwnerId(Long id);
}
