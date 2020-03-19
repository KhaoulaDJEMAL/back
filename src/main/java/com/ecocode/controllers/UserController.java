package com.ecocode.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecocode.entities.User;
import com.ecocode.repositories.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository; 
	
	@PostMapping("/create-compte")
	public String createEmployee(@RequestBody User user) {
		userRepository.save(user);
	    return "Hi" + user.getFname() + "your Resgistration process successfully completed";   
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/findUser/{fname}")
	public List<User> findUser(@PathVariable String fname) {
	     return userRepository.findByfname(fname);
	} 
	   
	@DeleteMapping("/cancel/{id}")
	public List<User> cancelUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return (List<User>) userRepository.findAll();
	}

}
