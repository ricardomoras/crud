package org.ricardo.api.crud.controllers;

import java.util.List;

import org.ricardo.api.crud.models.UserModel;
import org.ricardo.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserModel> getUsers(){
		return this.userService.getUsers();
	}
	
	

}
