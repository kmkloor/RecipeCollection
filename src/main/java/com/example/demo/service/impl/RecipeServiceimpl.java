package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.converter.RecipeConverter;
import com.example.demo.converter.TagConverter;
import com.example.demo.dto.RecipeDto;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.service.RecipeService;

@Service
public class RecipeServiceimpl  implements RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	@Override
	public RecipeDto getRecipeById(Integer recipeId) {
		return RecipeConverter.entityToDto(recipeRepository.getOne(recipeId));
	}

	@Override
	public void saveRecipe(RecipeDto recipeDto) {
		System.out.println(recipeDto.getRecipeId());
		if(recipeDto.getRecipeId() != null) {
			Recipe recipeFromDb = recipeRepository.findOne(recipeDto.getRecipeId());
			if(recipeDto.getRecipeId() == recipeFromDb.getRecipeId()) {
				recipeFromDb = RecipeConverter.dtoToExisting(recipeDto);
				recipeRepository.save(recipeFromDb);	
			}
		}
		else {
		recipeRepository.save(RecipeConverter.dtoToEntity(recipeDto));
		}
	}

	@Override
	public List<RecipeDto> getAllRecipes() {
		return recipeRepository.findAll(new Sort(Sort.Direction.DESC, "recipeId")).stream().map(RecipeConverter::entityToDto).collect(Collectors.toList());
	}

}