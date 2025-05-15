package com.itakademija.paint.gui;

import javax.swing.*;

public class PaintStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaintStarter::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        PaintWindow instance = PaintWindow.instance();
        instance.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instance.setVisible(true);
    }
}
