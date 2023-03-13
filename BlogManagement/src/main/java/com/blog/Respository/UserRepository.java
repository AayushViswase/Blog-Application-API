package com.blog.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
