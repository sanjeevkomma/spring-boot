package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.demo.model.User;  
import com.demo.service.UserService;  

@RestController  
public class UserController   { 

	@Autowired  
	UserService userService;  

	@GetMapping("/user")  
	private List<User> getAllStudent()   {  

		return userService.getAllUser();  
	}  

	@GetMapping("/user/{id}")  
	private User getStudent(@PathVariable("id") int id)   {

		return userService.getUserById(id);  
	}  

	@DeleteMapping("/user/{id}")  
	private void deleteStudent(@PathVariable("id") int id)   {  

		userService.delete(id);  
	}  

	@PostMapping("/user")  
	private int saveStudent(@RequestBody User user) {     

		userService.saveOrUpdate(user);  

		return user.getId();  
	}  
}  