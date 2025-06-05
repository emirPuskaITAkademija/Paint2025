package com.itakademija.paint.gui.menu;

import com.itakademija.paint.gui.listener.ExitListener;
import com.itakademija.paint.gui.listener.OpenListener;
import com.itakademija.paint.gui.listener.SaveListener;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureReaderFactory;
import com.itakademija.paint.xml.PictureWriterFactory;

import javax.swing.*;
import java.util.List;
import java.util.function.Consumer;

public class MenuBarCreator {

    private final List<PaintShape> paintShapes;
    private final Consumer<List<PaintShape>> onPictureOpen;
    private final Consumer<String> onPictureSave;

    public MenuBarCreator(List<PaintShape> paintShapes,
                          Consumer<List<PaintShape>> onPictureOpen,
                          Consumer<String> onPictureSave) {
        this.paintShapes = paintShapes;
        this.onPictureOpen = onPictureOpen;
        this.onPictureSave = onPictureSave;
    }

    public JMenuBar create(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        menuBar.add(fileMenu);


        JMenu saveWithMenu = new JMenu("Save With");
        createSaveMenuItem("SAX", 'S', PictureWriterFactory.SAX, paintShapes, saveWithMenu);
        createSaveMenuItem("DOM", 'D', PictureWriterFactory.DOM, paintShapes, saveWithMenu);
        createSaveMenuItem("StAX", 'T', PictureWriterFactory.STAX, paintShapes, saveWithMenu);
        createSaveMenuItem("JAXB", 'T', PictureWriterFactory.JAXB, paintShapes, saveWithMenu);

        fileMenu.add(saveWithMenu);

        JMenu openWithMenu = new JMenu("Open With");
        createOpenMenuItem("SAX", 'O', PictureReaderFactory.SAX, openWithMenu);
        createOpenMenuItem("DOM", 'M', PictureReaderFactory.DOM, openWithMenu);
        createOpenMenuItem("StAX", 'T', PictureReaderFactory.STAX, openWithMenu);
        createOpenMenuItem("JAXB", 'T', PictureReaderFactory.JAXB, openWithMenu);


        fileMenu.add(openWithMenu);

        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.addActionListener(new ExitListener());
        exitMenu.setMnemonic('E');
        fileMenu.add(exitMenu);
        return menuBar;
    }

    private void createOpenMenuItem(String label, char O, PictureReaderFactory sax, JMenu openMenu) {
        JMenuItem openMenuItem = new JMenuItem(label);
        openMenuItem.setMnemonic(O);
        openMenuItem.addActionListener(new OpenListener(sax.get(), onPictureOpen));
        openMenu.add(openMenuItem);
    }

    private void createSaveMenuItem(String SAX, char S, PictureWriterFactory sax, List<PaintShape> paintShapes, JMenu saveWithMenu) {
        JMenuItem saveMenuItem = new JMenuItem(SAX);
        saveMenuItem.setMnemonic(S);
        saveMenuItem.addActionListener(new SaveListener(sax.get(), paintShapes, onPictureSave));
        saveWithMenu.add(saveMenuItem);
    }
}
