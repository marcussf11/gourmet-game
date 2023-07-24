package com.gourmetgame.logic;

import com.gourmetgame.data.Strings;

import javax.swing.*;

public final class ScreenLogic {

    public static final ScreenLogic instance = new ScreenLogic();

    public int showOKConfirmDialog(String message){
        return JOptionPane.showConfirmDialog(null, message, Strings.GAME_TITLE, JOptionPane.DEFAULT_OPTION);
    }

    public int showYesNoConfirmDialog(String message){
        return JOptionPane.showConfirmDialog(null, message, Strings.GAME_TITLE, JOptionPane.YES_NO_OPTION);
    }

    public String showInputDialog(String message){
        return JOptionPane.showInputDialog(null, message);
    }
}
