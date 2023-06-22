package com.abnamro;

import com.abnamro.controllers.RecipeController;
import com.abnamro.repositories.RecipeRepository;
import com.abnamro.services.DaoToRecipeCreateResponseTransformer;
import com.abnamro.services.RecipeCreateRequestToDaoTransformer;
import com.abnamro.services.RecipeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeManagementAppTest {

    @Autowired
    RecipeController recipeController;

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCreateRequestToDaoTransformer recipeCreateRequestToDaoTransformer;

    @Autowired
    DaoToRecipeCreateResponseTransformer daoToRecipeCreateResponseTransformer;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(recipeController);
        Assert.assertNotNull(recipeService);
        Assert.assertNotNull(recipeRepository);
        Assert.assertNotNull(recipeCreateRequestToDaoTransformer);
        Assert.assertNotNull(daoToRecipeCreateResponseTransformer);
    }
}