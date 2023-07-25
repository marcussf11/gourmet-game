package com.gourmetgame.logic;

import com.gourmetgame.data.Database;
import com.gourmetgame.data.Strings;
import com.gourmetgame.model.Meal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class GourmetGame {

    public static final GourmetGame instance = new GourmetGame();

    private final Database database = Database.instance;
    private final MealLogic mealLogic = MealLogic.instance;
    private final PropertiesLogic propertiesLogic = PropertiesLogic.instance;
    private final ScreenLogic screenLogic = ScreenLogic.instance;

    public void start(){

        LinkedHashSet<Meal> localDatabase =  database.getCopy();
        LinkedHashSet<Meal> remainMeals = new LinkedHashSet<>();

        while(true) {
            remainMeals = remainMeals.isEmpty() ? database.getCopy() : (LinkedHashSet<Meal>)localDatabase.clone();

            LinkedHashSet<String> availableProperties = propertiesLogic.updateAvailablePropertiesByMeals(remainMeals);
            LinkedHashMap<String, Boolean> propertiesHistory = new LinkedHashMap<>();

            screenLogic.showOKConfirmDialog(Strings.THINK_MEAL_YOU_LIKE);

            guessMealByProperties(remainMeals, availableProperties, propertiesHistory);

            String mealNameAnswer = remainMeals.stream().findFirst().get().getMealName();
            boolean rightAnswer = guessMeal(mealNameAnswer);

            if (rightAnswer) {
                screenLogic.showOKConfirmDialog(Strings.SUCCESS_GUESS);
            } else {
                String newMealName = screenLogic.showInputDialog(Strings.QUESTION_INPUT_MEAL_NAME);
                String newMealProperty = screenLogic.showInputDialog(Strings.getNewMealInsertMessage(newMealName, mealNameAnswer));
                propertiesLogic.storeProperty(newMealProperty, true, propertiesHistory);

                Meal meal = mealLogic.createNewMeal(newMealName, propertiesHistory);
                localDatabase = database.insertMealLocalDatabase(localDatabase, meal);
                database.insertPropertyMealLocalDatabase(localDatabase, mealNameAnswer, newMealProperty, false);

            }
        }
    }

    private void guessMealByProperties(LinkedHashSet<Meal> remainMeals, LinkedHashSet<String> availableProperties, LinkedHashMap<String, Boolean> propertiesHistory){
        while (!mealLogic.haveAnswer(availableProperties, remainMeals)){
            String property = availableProperties.stream().findFirst().get();
            int answer = screenLogic.showYesNoConfirmDialog(Strings.getMealIsQuestionMessage(property));
            boolean booleanAnswer = intToBoolean(answer);

            propertiesLogic.storeProperty(property, booleanAnswer, propertiesHistory);

            mealLogic.processAnswer(property, booleanAnswer, remainMeals);

            availableProperties = propertiesLogic.updateAvailablePropertiesByMealsExceptHistory(remainMeals,propertiesHistory);
        }
    }

    private boolean guessMeal(String mealAnswer){
        int finalAnswer = screenLogic.showYesNoConfirmDialog(Strings.getMealIsAnswerMessage(mealAnswer));
        return intToBoolean(finalAnswer);
    }

    private boolean intToBoolean(int integer){
        return (integer == 0 ? true : false);
    }
}
