package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RecipeDto;
import com.example.demo.service.RecipeService;
import com.example.demo.utils.Constants;

@RequestMapping("/recipe")
@RestController
public class RecipeController {
	@Autowired
	RecipeService recipeService;

	@RequestMapping(Constants.GET_RECIPE_BY_ID)
	public RecipeDto getRecipeById(@PathVariable Integer recipeId) {
		return recipeService.getRecipeById(recipeId);
	}
	
	@RequestMapping(Constants.GET_ALL_RECIPES)
	public List<RecipeDto> getAllRecipes() {
		return recipeService.getAllRecipes();
	}
	
	@RequestMapping(value= Constants.SAVE_RECIPE, method= RequestMethod.POST)
	public void saveRecipe(@RequestBody RecipeDto recipeDto) {
		recipeService.saveRecipe(recipeDto);
	}
	
}