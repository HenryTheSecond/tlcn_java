package com.example.demo.service;


import com.example.demo.dto.category.SimpleCategoryDto;
import com.example.demo.model.DataResponse;

public interface CategoryService {
	public DataResponse getAllCategory();
	public DataResponse addCategory(SimpleCategoryDto category);
	public DataResponse deleteCategory(Long id);
	public DataResponse editCategory(Long id, SimpleCategoryDto simpleCategoryDto);
}
