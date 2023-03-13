package com.blog.Playload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	private String firstName;
	private String lastName;
	private String mailID;
	private String password;
	private String aboutUser;
}
