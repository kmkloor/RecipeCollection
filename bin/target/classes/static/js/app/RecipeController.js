'use strict'

var module = angular.module('demo.controllers', []);
module.controller("RecipeController", [ "$scope", "RecipeService",
		function($scope, RecipeService) {

			$scope.recipeDto = {
				recipeId : null,
				recipeName : null,
				recipeImage : null,
				recipeSteps : [],
				tagDtos : []
			};
			$scope.tags = [];
			
			RecipeService.getAllRecipes().then(function(value) {
				$scope.allRecipes= value.data;
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			

			$scope.saveRecipe = function() {
				$scope.recipeDto.tagDtos = $scope.tags.map(tag => {
					return {tagId: null, tagName: tag};
				});
				RecipeService.saveRecipe($scope.recipeDto).then(function() {
					console.log("works");
					RecipeService.getAllRecipes().then(function(value) {
						$scope.allRecipes= value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.tags = [];
					$scope.recipeDto = {
						recipeId : null,
						recipeName : null,
						recipeImage : null,
						recipeSteps : [],
						tagDtos : []
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
			
		} ]);