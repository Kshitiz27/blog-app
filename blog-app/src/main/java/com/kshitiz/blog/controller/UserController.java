package com.kshitiz.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kshitiz.blog.payloads.UserDto;
import com.kshitiz.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//POST method - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userdto){
		UserDto crtusr = this.userService.createUser(userdto);
		return new ResponseEntity<>(crtusr, HttpStatus.CREATED);
	}
	
	//PUT method - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userdto, @PathVariable Integer userId){
		UserDto updtusr = this.userService.updateUser(userdto, userId);
		return ResponseEntity.ok(updtusr);
	}
	
	//DELETE method - delete user
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return "User deleted successfully!";
	}
	
	//GET method - get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(UserDto userdto, @PathVariable Integer userId){
		UserDto getUsr = this.userService.getUserById(userId);
		return ResponseEntity.ok(getUsr);
	}
	
}
