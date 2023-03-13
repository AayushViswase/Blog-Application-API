package com.blog.Playload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private Integer userID;
	private String firstName;
	private String lastName;
	private String mailID;
	private String aboutUser;

}
