package com.gourmetgame.data;

import com.gourmetgame.model.Meal;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public final class PreSetDatabase {

    public static LinkedHashSet<Meal> getMealData(){

        LinkedHashMap propertiesLasagna = new LinkedHashMap<>();
        propertiesLasagna.put(PropertyConstant.PASTA, true);
        Meal lasagna = new Meal("Lasanha", propertiesLasagna);


        LinkedHashMap propertiesCake = new LinkedHashMap<>();
        propertiesCake.put(PropertyConstant.PASTA, false);
        Meal chocolateCake = new Meal("Bolo de Chocolate", propertiesCake);

        LinkedHashSet<Meal> data = new LinkedHashSet<>();
        data.add(lasagna);
        data.add(chocolateCake);

        return data;
    }
}
