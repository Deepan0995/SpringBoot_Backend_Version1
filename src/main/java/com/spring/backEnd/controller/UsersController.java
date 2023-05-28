package com.spring.backEnd.controller;

import com.spring.backEnd.model.Users;
import com.spring.backEnd.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsersController {
	
	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}
	
	@GetMapping("/getUserById/{userId}")
	public Users getUserById(@PathVariable Long userId)
	{
		return usersService.getUserById(userId);
	}
	
	@PostMapping("/saveUser")
	public Users saveUser(@RequestBody Users user) {
		return usersService.saveUser(user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		usersService.deleteUser(userId);
		return "User with ID " + userId + " has been deleted successfully.";
	}
	
	@GetMapping("/findUserByName/{userName}")
	Users getUserByName(@PathVariable String userName)
	{
		return usersService.getUserByName (userName);
	}
	@GetMapping("/findUserByMobile/{mobile}")
	Users getUserByMobile(@PathVariable String mobile)
	{
		return usersService.getUserByMobile (mobile);
	}
	

	
	
}
