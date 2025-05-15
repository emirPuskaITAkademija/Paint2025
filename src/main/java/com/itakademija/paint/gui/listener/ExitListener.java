package com.itakademija.paint.gui.listener;

import com.itakademija.paint.gui.PaintWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        PaintWindow.instance().dispose();
    }
}
