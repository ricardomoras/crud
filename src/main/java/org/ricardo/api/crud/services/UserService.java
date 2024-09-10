package org.ricardo.api.crud.services;

import java.util.List;
import java.util.Optional;

import org.ricardo.api.crud.models.UserModel;
import org.ricardo.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	IUserRepository userRepository;
	
	public List<UserModel> getUsers(){
		return (List<UserModel>) userRepository.findAll();
	}
	
	public UserModel saveUser(UserModel user) {
		return userRepository.save(user);
	}
	
	public Optional<UserModel> getById(Long id){
		return userRepository.findById(id);
	}
	
	public UserModel updateById(UserModel request,Long id){
		UserModel user = userRepository.findById(id).get();
		
		user.setFirtName(request.getFirtName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		
		return user;
	}
	
	public Boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
