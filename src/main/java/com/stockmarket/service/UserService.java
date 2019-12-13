package com.stockmarket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.entity.User;
import com.stockmarket.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	UserRepository userRepo;

	public User getUser(String userName) {
		return userRepo.findTopByUserName(userName);
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public User addUser(User userRequest) throws Exception {
		if(getUser(userRequest.getUserName())!=null)
			throw new Exception(userRequest.getUserName() + " kullanıcısı zaten bulunmakta!");
		userRequest.setCreateDate(new Date());
		return userRepo.save(userRequest);
	}

	public void deleteUser(String userName) throws Exception {
		if(getUser(userName)==null)
			throw new Exception(userName + " kullanıcısı bulunmamakta!");
		userRepo.delete(getUser(userName));
	}

	public User editUser(String userName, User userRequest) throws Exception {
		if(getUser(userName)==null)
			throw new Exception(userName + " kullanıcısı bulunmamakta!");
		userRequest.setId(getUser(userName).getId());
		userRequest.setLastModifiedDate(new Date());
		return userRepo.save(userRequest);
	}
	

}
