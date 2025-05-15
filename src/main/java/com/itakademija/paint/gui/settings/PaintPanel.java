package com.itakademija.paint.gui.settings;

import com.itakademija.paint.shape.PaintShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {

    private final List<PaintShape> paintShapes = new ArrayList<>();


    public PaintPanel() {
        setBackground(Color.WHITE);
    }
}
