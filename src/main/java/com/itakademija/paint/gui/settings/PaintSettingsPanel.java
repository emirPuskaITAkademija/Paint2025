package com.itakademija.paint.gui.settings;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PaintSettingsPanel extends JPanel {

    private final JRadioButton circleRadioButton = new JRadioButton("Circle");
    private final JRadioButton rectangleRadioButton = new JRadioButton("Rectangle");

    private final JRadioButton blueRadioButton = new JRadioButton("Blue");
    private final JRadioButton redRadioButton = new JRadioButton("Red");


    public PaintSettingsPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));


        TitledBorder titledBorder = new TitledBorder("Shape");
        JPanel shapePanel = new JPanel();
        shapePanel.setBorder(titledBorder);
        shapePanel.add(circleRadioButton);
        circleRadioButton.setSelected(true);
        shapePanel.add(rectangleRadioButton);
        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(circleRadioButton);
        shapeGroup.add(rectangleRadioButton);

        TitledBorder colorBorder = new TitledBorder("Color");
        JPanel colorPanel = new JPanel();
        colorPanel.setBorder(colorBorder);
        colorPanel.add(blueRadioButton);
        blueRadioButton.setSelected(true);
        colorPanel.add(redRadioButton);
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redRadioButton);
        colorGroup.add(blueRadioButton);

        add(shapePanel);
        add(colorPanel);
    }


    public boolean isCircleSelected() {
        return circleRadioButton.isSelected();
    }

    public boolean isRectangleSelected() {
        return rectangleRadioButton.isSelected();
    }

    public boolean isBlueSelected() {
        return blueRadioButton.isSelected();
    }

    public boolean isRedSelected() {
        return redRadioButton.isSelected();
    }
}
