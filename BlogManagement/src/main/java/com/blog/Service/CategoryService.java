
package com.blog.Service;

import java.util.List;

import com.blog.Exception.CategoryNotFountException;
import com.blog.Playload.Request.CategoryRequest;
import com.blog.Playload.Response.CategoryResponse;

public interface CategoryService {
	public CategoryResponse createCategory(CategoryRequest CategoryRequest);

	public CategoryResponse updateCategory(CategoryRequest CategoryRequest, Integer categoryID)
			throws CategoryNotFountException;

	public CategoryResponse getByCategoryID(Integer categoryID) throws CategoryNotFountException;

	public List<CategoryResponse> getAllCategory();

	public CategoryResponse deleteCategory(Integer categoryID) throws CategoryNotFountException;
}
