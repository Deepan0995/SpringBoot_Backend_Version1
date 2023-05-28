package com.spring.backEnd.service;

import com.spring.backEnd.model.Users;
import com.spring.backEnd.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	@Autowired
	public UsersService (UsersRepository usersRepository)
	{
		this.usersRepository = usersRepository;
	}
	
	public List<Users> getAllUsers ()
	{
		return usersRepository.findAll ();
	}
	
	public Users getUserById (Long userId) {
		return usersRepository.findById (userId).orElse (null);
	}
	
	public Users saveUser (Users user)
	{
		return usersRepository.save (user);
	}
	
	public void deleteUser (Long userId)
	{
	 usersRepository.deleteById (userId);
		
	}
	public Users getUserByName (String userName)
	{
		return usersRepository.findByUserName (userName);
	}
	
	public Users getUserByMobile(String mobile)
	{
		return usersRepository.findByMobile (mobile);
	}
}