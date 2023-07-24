package com.gourmetgame.model;

import java.util.HashMap;
import java.util.Objects;

public final class Meal {
    private final String mealName;
    private final HashMap<String, Boolean> properties;

    public Meal(String mealName, HashMap<String, Boolean> properties) {
        this.mealName = mealName;
        this.properties = properties;
    }

    public String getMealName() {
        return mealName;
    }

    public HashMap<String, Boolean> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(mealName, meal.mealName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealName);
    }
}
