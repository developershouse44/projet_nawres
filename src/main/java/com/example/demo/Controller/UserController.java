package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userrepository; 
	
	//post get put delete
	
	@PostMapping("/create")
	public User create (@RequestBody User us) {
		
		
		return userrepository.save(us);
	}
	
	@GetMapping ("users" )
	public List<User> affichelist(){
	return userrepository.findAll();
	}
	
	
	}

