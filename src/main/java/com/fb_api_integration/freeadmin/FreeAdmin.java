package com.fb_api_integration.freeadmin;

import javax.swing.*;

public class FreeAdmin  {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        GuiForm GUI = new GuiForm();
        GUI.setVisible(true);
    }
}
