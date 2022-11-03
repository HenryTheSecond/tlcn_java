package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.dto.category.SimpleCategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.GeneralException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.DataResponse;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public DataResponse getAllCategory() {
		return new DataResponse(categoryRepository.findAll().stream().map(categoryMapper::entityToSimpleCategoryDto).toList());
	}

	@Override
	public DataResponse addCategory(SimpleCategoryDto category) {
		try {
			Category newCategory = categoryRepository.save(categoryMapper.simpleCategoryDtoToEntity(category));
			return new DataResponse(categoryMapper.entityToSimpleCategoryDto(newCategory));
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new GeneralException("Category name has already existed");
		}
	}

	@Override
	public DataResponse deleteCategory(Long id) {
		try {
			categoryRepository.deleteById(id);
			return new DataResponse(true);
		} catch(EmptyResultDataAccessException ex) {
			ex.printStackTrace();
			throw new GeneralException("Category Not Found");
		}
	}

	@Override
	public DataResponse editCategory(Long id, SimpleCategoryDto simpleCategoryDto) {
		Category categoryDb = categoryRepository.findById(id)
				.orElseThrow(() -> new GeneralException(Constant.NOT_FOUND, Constant.NOT_FOUND_CODE));
		try {
			if (simpleCategoryDto.getName() != null && !simpleCategoryDto.getName().trim().equals(""))
				categoryDb.setName(simpleCategoryDto.getName());
			categoryRepository.save(categoryDb);
		} catch(DataIntegrityViolationException ex) {
			ex.printStackTrace();
			throw new GeneralException("Category name has already existed");
		}
		return new DataResponse(categoryMapper.entityToSimpleCategoryDto(categoryDb));
	}

}
