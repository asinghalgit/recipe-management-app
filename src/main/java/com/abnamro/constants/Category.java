package com.abnamro.constants;

import com.abnamro.error.InvalidInputException;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Category {

    VEG,
    NONVEG;

    public static Category fromString(final String value) {
        Category[] supportedCategories = Category.values();
        for (Category current : supportedCategories) {
            if (current.name().equalsIgnoreCase(value))
                return current;
        }
        throw new InvalidInputException(String.format("Category %s is not the valid value. Please supply one of the following values:%s", value, Arrays.stream(supportedCategories).collect(Collectors.toList())));
    }
}
