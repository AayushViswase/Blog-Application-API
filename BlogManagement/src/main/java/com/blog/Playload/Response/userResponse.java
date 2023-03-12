package com.blog.Playload.Response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.blog.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userResponse {
	private Integer userID;
	private String firstName;
	private String lastName;
	private String mailID;
	private String aboutUser;
	@Enumerated(EnumType.STRING)
	private Role role;

}
