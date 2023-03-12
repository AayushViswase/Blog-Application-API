package com.blog.Service;

import java.util.List;

import com.blog.Exception.UserNotFoundException;
import com.blog.Playload.Request.userRequest;
import com.blog.Playload.Response.userResponse;

public interface userService {
	public userResponse createUser(userRequest userRequest);

	public userResponse updateUser(userRequest userRequest, Integer userID) throws UserNotFoundException;

	void deleteUser(Integer userID) throws UserNotFoundException;

	public List<userResponse> getAllUsers();

	public userResponse getByIdUser(Integer userID) throws UserNotFoundException;
}
