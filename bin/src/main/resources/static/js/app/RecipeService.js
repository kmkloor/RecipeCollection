'use strict'

angular.module('demo.services', []).factory('RecipeService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getRecipeById = function(recipeId) {
				var url = CONSTANTS.getRecipeByIdUrl + recipeId;
				return $http.get(url);
			}
			service.getAllRecipes = function() {
				return $http.get(CONSTANTS.getAllRecipes);
			}
			service.saveRecipe = function(recipeDto) {
				return $http.post(CONSTANTS.saveRecipe, recipeDto);
			}
			return service;
		} ]);