package com.project.efaturatest.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.efaturatest.Entities.User;

public interface UserDataRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
	int isExists(String email);
	
	

}
