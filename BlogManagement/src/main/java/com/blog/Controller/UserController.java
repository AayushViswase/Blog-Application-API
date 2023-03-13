package com.blog.Controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Exception.UserNotFoundException;
import com.blog.Playload.Request.UserRequest;
import com.blog.Playload.Response.UserResponse;
import com.blog.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService UserService;

	@PostMapping("/create")
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest UserRequest) {
		UserResponse response = UserService.createUser(UserRequest);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<UserResponse> updateUser(@Valid @PathVariable Integer userID,
			@RequestBody UserRequest request)
			throws UserNotFoundException {
		UserResponse response= UserService.updateUser(request, userID);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userID}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable Integer userID) throws UserNotFoundException {
		UserService.deleteUser(userID);
		return new ResponseEntity(Map.of("message", "User deleted succesfully"), HttpStatus.OK);
	}

	@GetMapping("/{userID}")
	public ResponseEntity<UserResponse> getByIdUser(@PathVariable Integer userID) throws UserNotFoundException {
		UserResponse response=UserService.getByIdUser(userID);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/allUser")
	public ResponseEntity<List<UserResponse>> getAllUser() {
		List<UserResponse> list=UserService.getAllUsers();
		return new ResponseEntity<List<UserResponse>>(list,HttpStatus.OK);
	}
}
