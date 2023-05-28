package com.spring.backEnd.repository;

import com.spring.backEnd.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	
	Users findByUserName(String userName);
	Users findByMobile(String mobile);
}

