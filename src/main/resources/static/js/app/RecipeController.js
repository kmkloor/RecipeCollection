'use strict'
var module = angular.module('demo.controllers', []);
module.controller("RecipeController", [ "$scope",  "RecipeService",  "$timeout",
	function($scope, RecipeService, $timeout) {

	$scope.allRecipes= null;
	$scope.recipeDto = {
			recipeId : null,
			recipeName : null,
			recipeImage : null,
			recipeSteps : [],
			tagDtos : []
	};
	$scope.tags = [];
	$scope.newId= null;

	RecipeService.getRecipeById(1).then(function(value) {
		console.log(value.data);
	}, function(reason) {
		console.log("error occured");
	}, function(value) {
		console.log("no callback");
	});


	$scope.loadData = function () {
		RecipeService.getAllRecipes().then(function(value) {
			$scope.allRecipes= value.data;
		}, function(reason) {
			console.log("error occured");
		}, function(value) {
			console.log("no callback");
		});
	};

	$scope.recipeHandler = function() {
		$timeout($scope.saveRecipe, 1500);
	};

	$scope.blankRecipe = function (){
		RecipeService.saveRecipe($scope.recipeDto).then(function() {
			console.log("works");
			RecipeService.getAllRecipes().then(function(value) {
				$scope.allRecipes = value.data;
				console.log("saved");
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
		});
	}

	$scope.editRecipe = function(id) {	
			$scope.recipeDto.tagDtos = $scope.tags.map(tag => {
			return {tagId: null, tagName: tag};
		});
			$scope.recipeDto.recipeId = id;
		RecipeService.saveRecipe($scope.recipeDto).then(function() {
			console.log("works");
			RecipeService.getAllRecipes().then(function(value) {
				$scope.allRecipes = value.data;
				console.log("saved");
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.tempName = "";
			$scope.tempImage = "../images/default.jpg";
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


	$scope.saveRecipe = function() {		
		$scope.recipeDto.tagDtos = $scope.tags.map(tag => {
			return {tagId: null, tagName: tag};
		});
		RecipeService.saveRecipe($scope.recipeDto).then(function() {
			console.log("works");
			RecipeService.getAllRecipes().then(function(value) {
				$scope.allRecipes = value.data;
				console.log("saved");
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.tempName = "";
			$scope.tempImage = "../images/default.jpg";
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

	$scope.tempName = "";
	$scope.tempImage = "../images/default.jpg";

	$scope.changeName = function() {
		$scope.tempName = $scope.recipeDto.recipeName;
	};

	$scope.changeImage = function() {
		$scope.tempImage = $scope.recipeDto.recipeImage;
	};



	$scope.loadData();



} ]);


