package com.abnamro.request;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.List;

@Builder(toBuilder = true)
@EqualsAndHashCode
public class RecipeUpdateRequest {

    private final Integer id;
    private final String category;
    private final String name;
    private final Integer servings;
    private final List<String> ingredients;
    private final String instructions;

    public RecipeUpdateRequest(Integer id, String name, String category, Integer servings, List<String> ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Integer getId() {
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
