package com.abnamro;

import com.abnamro.domain.Recipe;
import com.abnamro.request.RecipeCreateRequest;
import com.abnamro.request.RecipeUpdateRequest;
import com.abnamro.response.RecipeApiResponse;
import com.abnamro.services.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeApiEndpointsTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RecipeService recipeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllRecipesTest() throws Exception {
        Recipe recipe = new Recipe(1, "pav bhaji", "VEG", 4,
                "paneer,onion,salt", "see youtube channel from sanjeev");

        RecipeApiResponse recipeApiResponse = RecipeApiResponse.builder()
                .id(recipe.getId()).category(recipe.getCategory()).ingredients(Arrays.asList("paneer", "onion", "salt"))
                .instructions(recipe.getInstructions()).servings(recipe.getServings()).name(recipe.getName()).build();
        Mockito.doReturn(Arrays.asList(recipeApiResponse)).when(recipeService).getAllRecipes();

        final String expectedResponseContent = objectMapper.writeValueAsString(Arrays.asList(recipeApiResponse));

        this.mvc.perform(MockMvcRequestBuilders.get("/api/recipes/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }

    @Test
    public void addRecipeTest() throws Exception {
        Recipe recipe = new Recipe(1, "pav bhaji", "VEG", 4,
                "paneer,onion,salt", "see youtube channel from sanjeev");

        RecipeCreateRequest recipeCreateRequest = RecipeCreateRequest.builder()
                .category(recipe.getCategory()).ingredients(Arrays.asList("paneer", "onion", "salt"))
                .name(recipe.getName()).servings(recipe.getServings()).instructions(recipe.getInstructions()).build();

        RecipeApiResponse recipeApiResponse = RecipeApiResponse.builder()
                .id(recipe.getId()).category(recipe.getCategory()).ingredients(Arrays.asList("paneer", "onion", "salt"))
                .instructions(recipe.getInstructions()).servings(recipe.getServings()).name(recipe.getName()).build();
        Mockito.doReturn(recipeApiResponse).when(recipeService).addRecipe(recipeCreateRequest);

        final String expectedResponseContent = objectMapper.writeValueAsString(recipeApiResponse);

        this.mvc.perform(MockMvcRequestBuilders.post("/api/recipe")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(recipeCreateRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }

    @Test
    public void updateRecipeTest() throws Exception {
        Recipe recipe = new Recipe(1, "pav bhaji", "VEG", 4,
                "paneer,onion,salt", "see youtube channel from sanjeev");

        RecipeUpdateRequest recipeUpdateRequest = RecipeUpdateRequest.builder()
                .id(recipe.getId()).category(recipe.getCategory()).instructions("mom will not make it")
                .name(recipe.getName()).servings(6).ingredients(Arrays.asList("paneer", "onion", "salt", "chilli")).build();

        RecipeApiResponse recipeApiResponse = RecipeApiResponse.builder()
                .id(recipeUpdateRequest.getId()).category(recipeUpdateRequest.getCategory())
                .ingredients(recipeUpdateRequest.getIngredients())
                .instructions(recipeUpdateRequest.getInstructions())
                .servings(recipeUpdateRequest.getServings()).name(recipeUpdateRequest.getName()).build();
        Mockito.doReturn(recipeApiResponse).when(recipeService).updateRecipe(recipeUpdateRequest);

        final String expectedResponseContent = objectMapper.writeValueAsString(recipeApiResponse);

        this.mvc.perform(MockMvcRequestBuilders.put("/api/recipe")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(recipeUpdateRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }

    @Test
    public void deleteRecipeTest() throws Exception {
        Mockito.doNothing().when(recipeService).deleteRecipe(1);
        this.mvc.perform(MockMvcRequestBuilders.delete("/api/recipe/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
