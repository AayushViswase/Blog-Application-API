package com.blog.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Exception.UserNotFoundException;
import com.blog.Model.User;
import com.blog.Playload.Request.userRequest;
import com.blog.Playload.Response.userResponse;
import com.blog.Respository.userRepository;

@Service
public class userServiceImpl implements userService {
	@Autowired
	private userRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public userResponse createUser(userRequest userRequest) {
		// TODO Auto-generated method stub
		User user = mapper.map(userRequest, User.class);
		User savedUser = userRepository.save(user);
		return mapper.map(savedUser, userResponse.class);

	}

	@Override
	public userResponse updateUser(userRequest userRequest, Integer userID) throws UserNotFoundException {
		// TODO Auto-generated method stub
		userRepository.findById(userID)
		.orElseThrow(() -> new UserNotFoundException("User not found with userID" + userID));
		User user = mapper.map(userRequest, User.class);
		User savedUser = userRepository.save(user);
		return mapper.map(savedUser, userResponse.class);

	}

	@Override
	public void deleteUser(Integer userID) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userID)
				.orElseThrow(() -> new UserNotFoundException("User not found with userID" + userID));
		userRepository.delete(user);

	}

	@Override
	public List<userResponse> getAllUsers() {
		// TODO Auto-generated method stub
		List<userResponse> response = userRepository.findAll().stream()
				.map(user -> mapper.map(user, userResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public userResponse getByIdUser(Integer userID) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userID)
				.orElseThrow(() -> new UserNotFoundException("User not found with userID" + userID));

		return mapper.map(user, userResponse.class);
	}


}
