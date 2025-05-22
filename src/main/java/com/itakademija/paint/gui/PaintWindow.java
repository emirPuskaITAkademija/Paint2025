package com.itakademija.paint.gui;

import com.itakademija.paint.gui.menu.MenuBarCreator;
import com.itakademija.paint.gui.paint.PaintPanel;
import com.itakademija.paint.gui.settings.PaintSettingsPanel;
import com.itakademija.paint.shape.PaintShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PaintWindow extends JFrame {

    private final PaintSettingsPanel paintSettingsPanel = new PaintSettingsPanel();
    private final PaintPanel paintPanel = new PaintPanel();

    private PaintWindow() {
        setTitle("Paint 2D");
        setSize(500, 300);
        add(paintSettingsPanel, BorderLayout.NORTH);
        add(paintPanel, BorderLayout.CENTER);
        MenuBarCreator menuBarCreator = new MenuBarCreator(paintPanel.getPaintShapes(),
                this::onPictureOpen,
                this::onPictureSave);
        JMenuBar menuBar = menuBarCreator.create();
        setJMenuBar(menuBar);
    }


    private void onPictureSave(String pictureName) {
        JOptionPane.showMessageDialog(null, "Slika '%s' je sačuvana".formatted(pictureName));
        paintPanel.clear();
    }

    public void onPictureOpen(List<PaintShape> paintShapes) {
        paintPanel.addPaintShapes(paintShapes);
    }

    public boolean isBlueColorSelected() {
        return paintSettingsPanel.isBlueSelected();
    }

    public boolean isRectangleShapeSelected() {
        return paintSettingsPanel.isRectangleSelected();
    }

    public List<PaintShape> getPaintShapes() {
        return paintPanel.getPaintShapes();
    }


    /*** Singleton PaintWindow****/

    private static PaintWindow instance;


    public static PaintWindow instance() {
        if (instance == null) {
            instance = new PaintWindow();
        }
        return instance;
    }
}
