package com.itakademija.paint.gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class PaintStarter {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
//        UIManager.setLookAndFeel(new FlatDarkLaf());
        SwingUtilities.invokeLater(PaintStarter::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        PaintWindow instance = PaintWindow.instance();
        instance.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instance.setVisible(true);
    }
}
