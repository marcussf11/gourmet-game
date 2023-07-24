package com.gourmetgame.data;

public final class Strings {

    public static final String GAME_TITLE = "Jogo Gourmet";
    public static final String THINK_MEAL_YOU_LIKE = "Pense em um prato que gosta!";
    public static final String QUESTION_INPUT_MEAL_NAME = "Qual prato você pensou?";
    public static final String SUCCESS_GUESS = "Acertei!  :D";

    private static final String INPUT_NEW_MEAL_MID = " é _______ mas ";
    private static final String INPUT_NEW_MEAL_END = " não.";
    private static final String MEAL_IS = "O prato que você pensou é ";
    private static final String QUESTION_MARK = "?";
    private static final String EXCLAMATION_MARK = "!";


    public static String getMealIsQuestionMessage(String mealName){
        StringBuilder message =
                new StringBuilder(MEAL_IS)
                    .append(mealName)
                    .append(QUESTION_MARK);

        return message.toString();
    }

    public static String getMealIsAnswerMessage(String mealName){
        StringBuilder message =
                new StringBuilder(MEAL_IS)
                        .append(mealName)
                        .append(EXCLAMATION_MARK);

        return message.toString();
    }

    public static String getNewMealInsertMessage(String newMealName, String wrongMealName){
        StringBuilder message =
                new StringBuilder(newMealName)
                        .append(INPUT_NEW_MEAL_MID)
                        .append(wrongMealName)
                        .append(INPUT_NEW_MEAL_END);

        return  message.toString();
    }

}
