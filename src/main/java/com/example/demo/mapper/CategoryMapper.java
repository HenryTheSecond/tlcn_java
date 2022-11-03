package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.category.SimpleCategoryDto;
import com.example.demo.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	SimpleCategoryDto entityToSimpleCategoryDto(Category category);
	Category simpleCategoryDtoToEntity(SimpleCategoryDto simpleCategoryDto);
}
