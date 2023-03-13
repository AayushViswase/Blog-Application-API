package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Exception.CategoryNotFountException;
import com.blog.Playload.Request.CategoryRequest;
import com.blog.Playload.Response.CategoryResponse;
import com.blog.Service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
		CategoryResponse response = categoryService.createCategory(categoryRequest);
		return new ResponseEntity<CategoryResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryRequest categoryRequest,
			@PathVariable Integer categoryID) throws CategoryNotFountException {
		CategoryResponse categoryResponse = categoryService.updateCategory(categoryRequest, categoryID);
		return new ResponseEntity<CategoryResponse>(categoryResponse, HttpStatus.OK);

	}

	@GetMapping("/{categoryID}")
	public ResponseEntity<CategoryResponse> getByCategoryID(@PathVariable Integer categoryID)
			throws CategoryNotFountException {
		CategoryResponse response=categoryService.getByCategoryID(categoryID);
		return new ResponseEntity<CategoryResponse>(response, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<CategoryResponse>> getAllCategory(){
		List<CategoryResponse> list=categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryResponse>>(list,HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable Integer categoryID)
			throws CategoryNotFountException {
		CategoryResponse response=categoryService.deleteCategory(categoryID);
		return new ResponseEntity<CategoryResponse>(response, HttpStatus.OK);
	}

}
