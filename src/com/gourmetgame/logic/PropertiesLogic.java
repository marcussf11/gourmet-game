package com.gourmetgame.logic;

import com.gourmetgame.model.Meal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class PropertiesLogic {

    public static final PropertiesLogic instance = new PropertiesLogic();

    public void storeProperty(String property, boolean answer, Map<String,Boolean> storage){
        storage.put(property, answer);
    }

    public HashSet<String> updateAvailablePropertiesByMeals(HashSet<Meal> meals){
        HashSet<String> properties = new HashSet();

        meals.stream().forEach( meal -> {

            meal.getProperties().entrySet().stream().forEach( entry -> {
                String property = entry.getKey();
                if(!properties.contains( property )){
                    properties.add( property);
                }
            });
        });

        return properties;
    }

    public HashSet<String> updateAvailablePropertiesByMealsExceptHistory(HashSet<Meal> meals, HashMap<String, Boolean> propertyHistory){
        HashSet<String> properties = new HashSet();

        meals.stream().forEach( meal -> {

            meal.getProperties().entrySet().stream().forEach( entry -> {
                String property = entry.getKey();
                if(!propertyHistory.containsKey(property)) {
                    if(!properties.contains( property )){
                        properties.add( property);
                    }
                }
            });
        });

        return properties;
    }
}
