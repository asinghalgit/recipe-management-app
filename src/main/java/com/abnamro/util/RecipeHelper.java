package com.abnamro.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RecipeHelper {

    public String convertIngredientsToString(List<String> ingredients) {
        return Optional.ofNullable(ingredients)
                .map(values -> String.join(",", values))
                .orElseThrow(() -> new IllegalArgumentException("provide list of ingredients"));
    }

    public List<String> convertIngredientsToList(String ingredients) {
        return Optional.ofNullable(ingredients)
                .map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
