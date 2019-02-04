package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipeDto {
    Integer recipeId;
    String recipeName;
    String recipeImage;
    String recipeColor;
    List<String> recipeSteps= new ArrayList<>();
    List<TagDto> tagDtos= new ArrayList<>();

    public RecipeDto(Integer recipeId, String recipeName, String recipeImage, String recipeColor, List<String> recipeSteps, List<TagDto> tagDtos) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
        this.recipeColor = recipeColor;
        this.recipeSteps = recipeSteps;
        this.tagDtos = tagDtos;
    }

    public RecipeDto() {
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    public String getRecipeColor() {
        return recipeColor;
    }
    
    public void setRecipeColor(String recipeColor) {
        this.recipeColor = recipeColor;
    }
    
    public String getRecipeImage() {
        return recipeImage;
    }
    
    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }
    
  
	public List<String> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<String> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }


    public List<TagDto> getTagDtos() {
        return tagDtos;
    }

    public void setTagDtos(List<TagDto> tagDtos) {
        this.tagDtos = tagDtos;
    }

}
