package com.itakademija.paint.gui;

import com.itakademija.paint.gui.listener.ExitListener;
import com.itakademija.paint.gui.listener.SaveListener;
import com.itakademija.paint.gui.settings.PaintPanel;
import com.itakademija.paint.gui.settings.PaintSettingsPanel;
import com.itakademija.paint.shape.PaintShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PaintWindow extends JFrame {

    private final PaintSettingsPanel paintSettingsPanel = new PaintSettingsPanel();
    private final PaintPanel paintPanel = new PaintPanel();

    private PaintWindow(){
        setTitle("Paint 2D");
        setSize(500, 300);

        //North
        add(paintSettingsPanel, BorderLayout.NORTH);
        add(paintPanel, BorderLayout.CENTER);

        //Prozor ima 3 menija u meni baru
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        menuBar.add(fileMenu);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setMnemonic('S');
        saveMenuItem.addActionListener(new SaveListener());
        fileMenu.add(saveMenuItem);

        JMenuItem editMenu = new JMenuItem("Open");
        editMenu.setMnemonic('O');
        fileMenu.add(editMenu);

        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.addActionListener(new ExitListener());
        exitMenu.setMnemonic('E');
        fileMenu.add(exitMenu);

        setJMenuBar(menuBar);
    }


    public boolean isBlueColorSelected(){
        return paintSettingsPanel.isBlueSelected();
    }

    public boolean isRectangleShapeSelected(){
        return paintSettingsPanel.isRectangleSelected();
    }

    public List<PaintShape> getPaintShapes(){
        return paintPanel.getPaintShapes();
    }

    public void clearPaintPanel(){
        paintPanel.clear();
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
