package org.ricardo.api.crud.services;

import java.util.List;

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
}
