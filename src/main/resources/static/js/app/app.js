'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getRecipeByIdUrl : "/recipe/getRecipe/",
	getAllRecipes : "/recipe/getAllRecipes",
	saveRecipe : "/recipe/saveRecipe"
});

