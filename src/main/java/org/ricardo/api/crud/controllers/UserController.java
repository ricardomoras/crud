package org.ricardo.api.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.ricardo.api.crud.models.UserModel;
import org.ricardo.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) {
		return this.userService.saveUser(user);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UserModel> getUserById(@PathVariable Long id){
		return this.userService.getById(id);
	}
	
	@PutMapping
	public UserModel updateUserById(@RequestBody UserModel request,@PathVariable Long id) {
		return userService.updateById(request, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable Long id) {
		
		boolean ok = userService.deleteUser(id);
		if(ok) {
			return "User with id " + id + " deleted!";
		} else {
			return "Error, we have a problem and can't delete user";
		}
	}
	

}
