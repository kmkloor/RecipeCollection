package com.example.demo.converter;

import java.awt.Image;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;

import com.example.demo.dto.RecipeDto;
import com.example.demo.entity.Recipe;

public class RecipeConverter {
	public static Recipe dtoToEntity(RecipeDto recipeDto) {
		Recipe recipe = new Recipe(recipeDto.getRecipeName(), null);
		recipe.setRecipeId(recipeDto.getRecipeId());
		recipe.setRecipeImage(recipeDto.getRecipeImage());
		recipe.setRecipeSteps(recipeDto.getRecipeSteps());
		recipe.setTags(recipeDto.getTagDtos().stream().map(TagConverter::dtoToEntity).collect(Collectors.toList()));
		return recipe;
	}
	
	public static Recipe dtoToExisting(RecipeDto recipeDto) {
		Recipe recipe = new Recipe(recipeDto.getRecipeId());
		recipe.setRecipeName(recipeDto.getRecipeName());
		recipe.setRecipeImage(recipeDto.getRecipeImage());
		recipe.setRecipeSteps(recipeDto.getRecipeSteps());
		recipe.setTags(recipeDto.getTagDtos().stream().map(TagConverter::dtoToEntity).collect(Collectors.toList()));
		return recipe;
	}

	public static RecipeDto entityToDto(Recipe recipe) {
		RecipeDto recipeDto = new RecipeDto(recipe.getRecipeId(), recipe.getRecipeName(), recipe.getRecipeImage(), recipe.getRecipeColor(), recipe.getRecipeSteps(), null);
		recipeDto.setTagDtos(recipe.getTags().stream().map(TagConverter::entityToDto).collect(Collectors.toList()));
		return recipeDto;
	}

}
