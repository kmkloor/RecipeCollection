package com.example.demo;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.Tag;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


import java.util.Arrays;

@SpringBootApplication
public class BootDemoApplication {
	@Autowired
	RecipeRepository recipeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){
		Recipe bruschetta = new Recipe("Bruschetta", null);
		bruschetta.setRecipeImage("../images/bruschetta.jpg");
		bruschetta.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Appetizer")));
		
		
		Recipe burger = new Recipe("GardenBurger", null);
		burger.setRecipeImage("../images/burger.jpg");
		burger.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Appetizer")));
		
		
		Recipe cherryPie = new Recipe("Cherry Pie", null);
		cherryPie.setRecipeImage("../images/cherrypie.jpg");
		cherryPie.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Dessert")));
		
		
		Recipe juice = new Recipe("Cranberry Seltzer", null);
		juice.setRecipeImage("../images/juice.jpg");
		juice.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Appetizer")));
		
		
		Recipe figs = new Recipe("Fig Platter", null);
		figs.setRecipeImage("../images/figs.jpg");
		figs.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Appetizer")));
		
		
		Recipe bread = new Recipe("Wheat Bread", null);
		bread.setRecipeImage("../images/bread.jpg");
		bread.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Appetizer")));
		
		
		Recipe salmon = new Recipe("Salmon Stew", null);
		salmon.setRecipeImage("../images/salmon.jpg");
		salmon.setTags(Arrays.asList(new Tag("Ready in 30"), new Tag("Appetizer")));
		
		salmon= recipeRepository.save(salmon);
		bread= recipeRepository.save(bread);
		figs= recipeRepository.save(figs);
		juice= recipeRepository.save(juice);
		cherryPie= recipeRepository.save(cherryPie);
		burger= recipeRepository.save(burger);
		bruschetta= recipeRepository.save(bruschetta);
	}
}
