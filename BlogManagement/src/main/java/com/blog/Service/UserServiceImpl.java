package com.blog.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Exception.UserNotFoundException;
import com.blog.Model.User;
import com.blog.Playload.Request.UserRequest;
import com.blog.Playload.Response.UserResponse;
import com.blog.Respository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserResponse createUser(UserRequest UserRequest) {
		// TODO Auto-generated method stub
		// System.out.println("sadasdas");
		//User user = mapper.map(userRequest, User.class)
		User user = new User();
		user.setFirstName(UserRequest.getFirstName());
		user.setLastName(UserRequest.getLastName());
		user.setMailID(UserRequest.getMailID());
		user.setPassword(UserRequest.getPassword());
		user.setAboutUser(UserRequest.getAboutUser());
		// user = mapper.map(userRequest, User.class);

		System.out.println("sadasdas");
		User savedUser = UserRepository.save(user);
		return mapper.map(savedUser, UserResponse.class);

	}

	@Override
	public UserResponse updateUser(UserRequest UserRequest, Integer userID) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserRepository.findById(userID)
		.orElseThrow(() -> new UserNotFoundException("User not found with userID" + userID));
		User user = mapper.map(UserRequest, User.class);
		User savedUser = UserRepository.save(user);
		return mapper.map(savedUser, UserResponse.class);

	}

	@Override
	public UserResponse deleteUser(Integer userID) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = UserRepository.findById(userID)
				.orElseThrow(() -> new UserNotFoundException("User not found with userID" + userID));
		UserRepository.delete(user);
		return mapper.map(user, UserResponse.class);

	}

	@Override
	public List<UserResponse> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserResponse> response = UserRepository.findAll().stream()
				.map(user -> mapper.map(user, UserResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public UserResponse getByIdUser(Integer userID) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = UserRepository.findById(userID)
				.orElseThrow(() -> new UserNotFoundException("User not found with userID" + userID));

		return mapper.map(user, UserResponse.class);
	}


}
