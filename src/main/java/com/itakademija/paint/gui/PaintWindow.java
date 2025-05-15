package com.itakademija.paint.gui;

import com.itakademija.paint.gui.listener.ExitListener;
import com.itakademija.paint.gui.settings.PaintPanel;
import com.itakademija.paint.gui.settings.PaintSettingsPanel;

import javax.swing.*;
import java.awt.*;

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

        JMenuItem openMenuItem = new JMenuItem("Otvori");
        openMenuItem.setMnemonic('O');
        fileMenu.add(openMenuItem);

        JMenuItem editMenu = new JMenuItem("Otvori");
        editMenu.setMnemonic('O');
        fileMenu.add(editMenu);

        JMenuItem exitMenu = new JMenuItem("Izlaz");
        exitMenu.addActionListener(new ExitListener());
        exitMenu.setMnemonic('I');
        fileMenu.add(exitMenu);

        setJMenuBar(menuBar);
    }


    public boolean isBlueColorSelected(){
        return paintSettingsPanel.isBlueSelected();
    }

    public boolean isRectangleShapeSelected(){
        return paintSettingsPanel.isRectangleSelected();
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
