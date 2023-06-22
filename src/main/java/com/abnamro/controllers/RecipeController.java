package com.abnamro.controllers;

import com.abnamro.request.RecipeCreateRequest;
import com.abnamro.request.RecipeUpdateRequest;
import com.abnamro.response.RecipeApiResponse;
import com.abnamro.services.RecipeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@ApiOperation("Recipe CRUD API")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/recipes/all")
    @ApiOperation(value = "Get all recipes", notes = "This API returns all the existing recipes.")
    public List<RecipeApiResponse> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping(value = "/recipe", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new recipe", notes = "This API allows us to add a new recipe.")
    public RecipeApiResponse addRecipes(@RequestBody RecipeCreateRequest recipeCreateRequest) {
        return recipeService.addRecipe(recipeCreateRequest);
    }

    @PutMapping(value = "/recipe", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "updates existing recipe", notes = "This API allows us to modify properties of a recipe")
    public RecipeApiResponse updateRecipe(@RequestBody RecipeUpdateRequest recipeUpdateRequest) {
        return recipeService.updateRecipe(recipeUpdateRequest);
    }

    @DeleteMapping(value = "/recipe/{id}")
    @ApiOperation(value = "delete recipe with provided id",
            notes = "This API deletes recipe with given input id")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeService.deleteRecipe(id);
    }

}
