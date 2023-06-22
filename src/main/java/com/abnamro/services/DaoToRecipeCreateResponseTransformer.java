package com.abnamro.services;

import com.abnamro.domain.Recipe;
import com.abnamro.response.RecipeApiResponse;
import com.abnamro.util.RecipeHelper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoToRecipeCreateResponseTransformer {

    private final RecipeHelper recipeHelper;

    public DaoToRecipeCreateResponseTransformer(RecipeHelper recipeHelper) {
        this.recipeHelper = recipeHelper;
    }

    public RecipeApiResponse convertDaoResponseToApiResponse(final Recipe recipe) {
        List<String> ingredients = recipeHelper.convertIngredientsToList(recipe.getIngredients());
        return new RecipeApiResponse(
                recipe.getId(), recipe.getName(), recipe.getCategory(), recipe.getServings(), ingredients, recipe.getInstructions()
        );
    }
}
