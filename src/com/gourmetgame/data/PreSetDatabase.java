package com.gourmetgame.data;

import com.gourmetgame.model.Meal;

import java.util.HashMap;
import java.util.HashSet;

public final class PreSetDatabase {

    public static HashSet<Meal> getMealData(){

        HashMap propertiesLasagna = new HashMap<>();
        propertiesLasagna.put(PropertyConstant.PASTA, true);
        Meal lasagna = new Meal("Lasanha", propertiesLasagna);


        HashMap propertiesCake = new HashMap<>();
        propertiesCake.put(PropertyConstant.PASTA, false);
        Meal chocolateCake = new Meal("Bolo de Chocolate", propertiesCake);

        HashSet<Meal> data = new HashSet<>();
        data.add(lasagna);
        data.add(chocolateCake);

        return data;
    }
}
