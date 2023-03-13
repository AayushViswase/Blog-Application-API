package com.blog.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Exception.CategoryNotFountException;
import com.blog.Model.Category;
import com.blog.Playload.Request.CategoryRequest;
import com.blog.Playload.Response.CategoryResponse;
import com.blog.Respository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public CategoryResponse createCategory(CategoryRequest CategoryRequest) {
		// Category category = mapper.map(CategoryRequest, Category.class);
		Category category = new Category();
		System.out.println("sadasdas");
		category.setTitle(CategoryRequest.getTitle());
		category.setDescription(CategoryRequest.getDescription());
		Category savedCategory = CategoryRepository.save(category);
		System.out.println("sadasdas");

		return mapper.map(savedCategory, CategoryResponse.class);
	}
	@Override
	public CategoryResponse updateCategory(CategoryRequest CategoryRequest, Integer categoryID)
			throws CategoryNotFountException {
		CategoryRepository.findById(categoryID)
		.orElseThrow(() -> new CategoryNotFountException("Category not found with ID" + categoryID));
		Category category = mapper.map(categoryID, Category.class);
		Category savedCategory = CategoryRepository.save(category);

		return mapper.map(savedCategory, CategoryResponse.class);
	}
	@Override
	public CategoryResponse getByCategoryID(Integer categoryID) throws CategoryNotFountException {

		CategoryRepository.findById(categoryID)
		.orElseThrow(() -> new CategoryNotFountException("Category not found with ID" + categoryID));
		Optional<Category> category = CategoryRepository.findById(categoryID);

		return mapper.map(category, CategoryResponse.class);
	}
	@Override
	public List<CategoryResponse> getAllCategory() {
		List<CategoryResponse> responses = CategoryRepository.findAll().stream()
				.map(category -> mapper.map(category, CategoryResponse.class)).collect(Collectors.toList());
		return responses;
	}
	@Override
	public CategoryResponse deleteCategory(Integer categoryID) throws CategoryNotFountException {

		CategoryRepository.findById(categoryID)
		.orElseThrow(() -> new CategoryNotFountException("Category not found with ID" + categoryID));
		CategoryRepository.deleteById(categoryID);
		return mapper.map(categoryID, CategoryResponse.class);
	}



}
