package com.ecocode.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PutMapping;


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
	
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId){
		User employee = userRepository.findById(userId).get();
		return ResponseEntity.ok().body(employee);
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody User user) {
		User employee = userRepository.findById(employeeId).get() ;

		employee.setFname(employee.getFname());
		employee.setLname(employee.getLname());
		userRepository.save(user);

		//return "hi" + employee.getFname() + "your Resgistration process successfully completed";
		final User updatedEmployee = userRepository.save(user);
		return ResponseEntity.ok(updatedEmployee);
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
