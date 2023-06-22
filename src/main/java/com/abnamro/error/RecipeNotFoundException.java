package com.abnamro.error;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(Integer id)
    {
        super(String.format("Recipe with id %s not found", id));
    }

}
