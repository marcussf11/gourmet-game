package com.gourmetgame.data;

import com.gourmetgame.model.Meal;

import java.util.LinkedHashSet;


public final class Database {

    public static final Database instance = new Database();

    private LinkedHashSet<Meal> getMeals(){
        return PreSetDatabase.getMealData();
    }

    public LinkedHashSet<Meal> getCopy(){
        return (LinkedHashSet<Meal>) getMeals().clone();
    }

    public LinkedHashSet<Meal> insertMealLocalDatabase(LinkedHashSet<Meal> meals, Meal meal){
        meals.add(meal);
        return meals;
    }

    public LinkedHashSet<Meal> insertPropertyMealLocalDatabase(LinkedHashSet<Meal> meals, String mealName, String property, boolean value){
        meals.stream()
                .filter( meal -> meal.getMealName().equals(mealName))
                .findFirst().get().getProperties().put(property,value);
        return meals;
    }

}
