package com.gourmetgame.data;

import com.gourmetgame.model.Meal;

import java.util.HashSet;

public final class Database {

    public static final Database instance = new Database();

    private HashSet<Meal> getMeals(){
        return PreSetDatabase.getMealData();
    }

    public HashSet<Meal> getCopy(){
        return (HashSet<Meal>) getMeals().clone();
    }

    public HashSet<Meal> insertMealLocalDatabase(HashSet<Meal> meals, Meal meal){
        meals.add(meal);
        return meals;
    }

    public HashSet<Meal> insertPropertyMealLocalDatabase(HashSet<Meal> meals, String mealName, String property, boolean value){
        meals.stream()
                .filter( meal -> meal.getMealName().equals(mealName))
                .findFirst().get().getProperties().put(property,value);
        return meals;
    }

}
