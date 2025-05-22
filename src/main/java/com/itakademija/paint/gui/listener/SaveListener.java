package com.itakademija.paint.gui.listener;

import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

import static com.itakademija.paint.xml.PictureWriter.PICTURE_EXTENSIONS;


//Head First Design Patterns -> depend
public class SaveListener implements ActionListener {
    private final PictureWriter pictureWriter;
    private final List<PaintShape> paintShapes;
    private final Consumer<String> consumer;

    public SaveListener(PictureWriter pictureWriter, List<PaintShape> paintShapes, Consumer<String> consumer) {
        this.pictureWriter = pictureWriter;
        this.paintShapes = paintShapes;
        this.consumer = consumer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pictureName = JOptionPane.showInputDialog("Unesite ime slike");
        if (pictureName == null || pictureName.isEmpty()) {
            return;
        }
        if (!pictureName.endsWith(PICTURE_EXTENSIONS)) {
            pictureName = pictureName + PICTURE_EXTENSIONS;
        }
        pictureWriter.write(pictureName, paintShapes);
        consumer.accept(pictureName);
    }
}
