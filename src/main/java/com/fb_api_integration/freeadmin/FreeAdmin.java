package com.fb_api_integration.freeadmin;

import javax.swing.*;

import java.util.Timer;

public class FreeAdmin  {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        GuiForm GUI = new GuiForm();
        GUI.setVisible(true);

        Timer postTimer = new Timer();
        PostTimerTask timerTask = new PostTimerTask();
        postTimer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}
