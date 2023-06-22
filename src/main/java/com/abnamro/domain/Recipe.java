package com.abnamro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String category;
    private Integer servings;
    private String ingredients;
    private String instructions;

    public Recipe() {
    }

    public Recipe(final String name, final String category, final Integer servings, final String ingredients, final String instructions) {
        super();
        this.name = name;
        this.category = category;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe(final Integer id, final String name, final String category, final Integer servings, final String ingredients, final String instructions) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.servings = servings;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getServings() {
        return servings;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public Integer getId() {
        return id;
    }
}
