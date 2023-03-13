package com.blog.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


}
