package com.itakademija.paint.gui.listener;

import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

public class OpenListener implements ActionListener {

    public static String PICTURE_EXTENSION = ".nfs";
    //depend upon abstraction not upon concrete implementation
    private final PictureReader pictureReader;
    private final Consumer<List<PaintShape>> shapesConsumer;

    public OpenListener(PictureReader pictureReader, Consumer<List<PaintShape>> shapesConsumer) {
        this.pictureReader = pictureReader;
        this.shapesConsumer = shapesConsumer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pictureName = JOptionPane.showInputDialog("Unesi ime slike: ");
        if(pictureName == null || pictureName.isBlank()) {
            return;
        }
        if(!pictureName.endsWith(PICTURE_EXTENSION)){
            pictureName += PICTURE_EXTENSION;
        }
        List<PaintShape> paintShapes = pictureReader.read(pictureName);
        shapesConsumer.accept(paintShapes);
    }
}
