package com.abnamro.services;

import com.abnamro.domain.Recipe;
import com.abnamro.error.RecipeNotFoundException;
import com.abnamro.repositories.RecipeRepository;
import com.abnamro.request.RecipeCreateRequest;
import com.abnamro.request.RecipeUpdateRequest;
import com.abnamro.response.RecipeApiResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private final RecipeCreateRequestToDaoTransformer recipeCreateRequestToDaoTransformer;

    private final DaoToRecipeCreateResponseTransformer daoToRecipeCreateResponseTransformer;

    public RecipeService(final RecipeRepository recipeRepository,
                         final RecipeCreateRequestToDaoTransformer recipeCreateRequestToDaoTransformer,
                         final DaoToRecipeCreateResponseTransformer daoToRecipeCreateResponseTransformer) {
        this.recipeRepository = recipeRepository;
        this.recipeCreateRequestToDaoTransformer = recipeCreateRequestToDaoTransformer;
        this.daoToRecipeCreateResponseTransformer = daoToRecipeCreateResponseTransformer;
    }

    public List<RecipeApiResponse> getAllRecipes() {
        return Optional.ofNullable(recipeRepository.findAll())
                .map(recipes ->
                        recipes.stream()
                                .map(recipe -> daoToRecipeCreateResponseTransformer.convertDaoResponseToApiResponse(recipe))
                                .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public RecipeApiResponse addRecipe(RecipeCreateRequest recipeCreateRequest) {
        Recipe recipe = recipeCreateRequestToDaoTransformer.convertRequestToDao(recipeCreateRequest);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return daoToRecipeCreateResponseTransformer.convertDaoResponseToApiResponse(savedRecipe);
    }

    public RecipeApiResponse updateRecipe(RecipeUpdateRequest recipeUpdateRequest) {
        return recipeRepository.findById(recipeUpdateRequest.getId())
                .map(recipe -> {
                    Recipe updatedRecipe = recipeCreateRequestToDaoTransformer.convertRequestToDao(recipeUpdateRequest);
                    Recipe savedRecipe = recipeRepository.save(updatedRecipe);
                    return daoToRecipeCreateResponseTransformer.convertDaoResponseToApiResponse(savedRecipe);
                })
                .orElseThrow(() -> new RecipeNotFoundException(recipeUpdateRequest.getId()));
    }

    public void deleteRecipe(final Integer id) {
        if (recipeRepository.findById(id).isPresent()) {
            recipeRepository.deleteById(id);
        } else {
            throw new RecipeNotFoundException(id);
        }
    }

}
