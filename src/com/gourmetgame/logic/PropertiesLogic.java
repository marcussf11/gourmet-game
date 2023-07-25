package com.gourmetgame.logic;

import com.gourmetgame.model.Meal;

import java.util.*;

public final class PropertiesLogic {

    public static final PropertiesLogic instance = new PropertiesLogic();

    public void storeProperty(String property, boolean answer, Map<String,Boolean> storage){
        storage.put(property, answer);
    }

    public LinkedHashSet<String> updateAvailablePropertiesByMeals(LinkedHashSet<Meal> meals){
        LinkedHashSet<String> properties = new LinkedHashSet();

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

    public LinkedHashSet<String> updateAvailablePropertiesByMealsExceptHistory(LinkedHashSet<Meal> meals, LinkedHashMap<String, Boolean> propertyHistory){
        LinkedHashSet<String> properties = new LinkedHashSet();

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
