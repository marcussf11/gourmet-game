package com.gourmetgame.logic;

import com.gourmetgame.model.Meal;

import java.util.HashMap;
import java.util.HashSet;

public final class MealLogic {

    public static final MealLogic instance = new MealLogic();

    public Meal createNewMeal(String newMealName, HashMap<String, Boolean> propertiesHistory){
        return new Meal(newMealName, propertiesHistory);
    }

    public void processAnswer(String property, boolean answer, HashSet<Meal> meals){
        HashSet<Meal> remainMeals = (HashSet<Meal>) meals.clone();

        remainMeals.stream().forEach(meal -> {
            //if meal have the property but the value is not equals the answer, than remove it
            if(meal.getProperties().containsKey(property)){
                if(!isPropertyEqualsAnswer(meal.getProperties().get(property), answer)){
                    meals.remove( meal );
                }
            }

            // if meal do not have the property and the answer is true, then remove it
            if(!meal.getProperties().containsKey(property) && answer){
                meals.remove( meal );
            }
        });
    }

    public boolean haveAnswer(HashSet<String> remainProperties, HashSet<Meal> remainMeals){
        return (remainMeals.size() == 1 || remainProperties.isEmpty());
    }

    private static boolean isPropertyEqualsAnswer(boolean propertyBoolean, Boolean answer){
        return propertyBoolean == answer;
    }
}
