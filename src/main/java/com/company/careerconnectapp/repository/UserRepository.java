package com.company.careerconnectapp.repository;


import com.company.careerconnectapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findDistinctByEmail(String email);
	
	public List<User> findAllByOrderByCreatedAtDesc();

}
