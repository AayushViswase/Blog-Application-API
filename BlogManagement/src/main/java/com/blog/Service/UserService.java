package com.blog.Service;

import java.util.List;

import com.blog.Exception.UserNotFoundException;
import com.blog.Playload.Request.UserRequest;
import com.blog.Playload.Response.UserResponse;

public interface UserService {
	public UserResponse createUser(UserRequest UserRequest);

	public UserResponse updateUser(UserRequest UserRequest, Integer userID) throws UserNotFoundException;

	public UserResponse deleteUser(Integer userID) throws UserNotFoundException;

	public List<UserResponse> getAllUsers();

	public UserResponse getByIdUser(Integer userID) throws UserNotFoundException;
}
