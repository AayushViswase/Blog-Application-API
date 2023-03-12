package com.blog.Model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer userID;
	private String firstName;
	private String lastName;
	private String mailID;
	private String password;
	private String abouteUser;
}
