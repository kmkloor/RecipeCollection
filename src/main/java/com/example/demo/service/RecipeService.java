package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RecipeDto;

public interface RecipeService {
    RecipeDto getRecipeById(Integer recipeId);
    void saveRecipe(RecipeDto recipeDto);
    List<RecipeDto> getAllRecipes();
}