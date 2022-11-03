package com.example.demo.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotations.IsNumber;
import com.example.demo.dto.category.SimpleCategoryDto;
import com.example.demo.model.DataResponse;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public DataResponse getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	@PostMapping
	public DataResponse addCategory(@RequestBody SimpleCategoryDto category) throws SQLIntegrityConstraintViolationException {
		return categoryService.addCategory(category);
	}
	
	@DeleteMapping("/{id}")
	public DataResponse deleteCategory(@PathVariable("id") @IsNumber(message = "Id is invalid") String strId) {
		return categoryService.deleteCategory(Long.parseLong(strId));
	}
	
	@PutMapping("/{id}")
	public DataResponse editCategory(@PathVariable("id") @IsNumber(message = "Id is invalid") String strId, @RequestBody SimpleCategoryDto category) {
		return categoryService.editCategory(Long.parseLong(strId), category);
	}
}
