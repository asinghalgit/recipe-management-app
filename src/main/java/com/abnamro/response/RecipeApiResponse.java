package com.abnamro.response;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public class RecipeApiResponse {

    private final int id;
    private final String name;
    private final String category;
    private final Integer servings;
    private final List<String> ingredients;
    private final String instructions;

    public RecipeApiResponse(int id, String name, String category, Integer servings, List<String> ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public Integer getServings() {
        return servings;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getName() {
        return name;
    }
}
