package com.spring.backEnd.exception;

import org.springframework.web.bind.annotation.GetMapping;



public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException (Long id) {
		super ("Could Not Find User With Id: " + id);
		
	}

}
