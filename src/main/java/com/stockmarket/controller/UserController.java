package com.stockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.entity.User;
import com.stockmarket.service.SecurityServiceImpl;
import com.stockmarket.service.StockService;
import com.stockmarket.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityServiceImpl securityService;
	
    @GetMapping("/login")
    public String login(
    		@RequestParam String username, 
    		@RequestParam String password
    		) {

        securityService.autoLogin(username, password);
		return "OK";
    }
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) {
		
		return userService.getUser(userName);
	}
	
	@GetMapping
	public List<User> getUsers() {
		
		return userService.getUsers();
	}
	
	@PostMapping
	public User addUser(@RequestBody User userRequest) throws Exception {
		return userService.addUser(userRequest);
	}
	@PutMapping("/{userName}")
	public User editUser(@PathVariable String userName, @RequestBody User userRequest) throws Exception {
		return userService.editUser(userName, userRequest);
	}
	@DeleteMapping
	public void deleteUser(String userName) throws Exception {
		userService.deleteUser(userName);
	}

}
