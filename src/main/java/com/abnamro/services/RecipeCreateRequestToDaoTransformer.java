package com.abnamro.services;

import com.abnamro.constants.Category;
import com.abnamro.domain.Recipe;
import com.abnamro.request.RecipeCreateRequest;
import com.abnamro.request.RecipeUpdateRequest;
import com.abnamro.util.RecipeHelper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeCreateRequestToDaoTransformer {

    private final RecipeHelper recipeHelper;

    public RecipeCreateRequestToDaoTransformer(RecipeHelper recipeHelper) {
        this.recipeHelper = recipeHelper;
    }

    public Recipe convertRequestToDao(RecipeCreateRequest recipeCreateRequest) {
        Category category = Category.fromString(recipeCreateRequest.getCategory());
        List<String> ingredients = recipeCreateRequest.getIngredients();
        String daoIngredients = recipeHelper.convertIngredientsToString(ingredients);
        return new Recipe(recipeCreateRequest.getName(), category.name(), recipeCreateRequest.getServings(),
                daoIngredients, recipeCreateRequest.getInstructions());
    }

    public Recipe convertRequestToDao(RecipeUpdateRequest recipeUpdateRequest) {
        Category category = Category.fromString(recipeUpdateRequest.getCategory());
        List<String> ingredients = recipeUpdateRequest.getIngredients();
        String daoIngredients = recipeHelper.convertIngredientsToString(ingredients);
        return new Recipe(recipeUpdateRequest.getId(), recipeUpdateRequest.getName(), category.name(), recipeUpdateRequest.getServings(),
                daoIngredients, recipeUpdateRequest.getInstructions());
    }
}
