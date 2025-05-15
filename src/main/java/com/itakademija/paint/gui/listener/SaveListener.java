package com.itakademija.paint.gui.listener;

import com.itakademija.paint.gui.PaintWindow;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveListener implements ActionListener {

    private static final String PICTURE_EXTENSIONS = ".nfs";

    //.svg  .nfs
    @Override
    public void actionPerformed(ActionEvent e) {
        PaintWindow paintWindow = PaintWindow.instance();

        String pictureName = JOptionPane.showInputDialog("Unesite ime slike");
        if (pictureName == null || pictureName.isEmpty()) {
            return;
        }
        if (!pictureName.endsWith(PICTURE_EXTENSIONS)) {
            pictureName = pictureName + PICTURE_EXTENSIONS;
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(pictureName))) {
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<shapes>");
            List<PaintShape> paintShapes = paintWindow.getPaintShapes();
            for (PaintShape paintShape : paintShapes) {
                out.println("<shape>");
                out.println("<x>" + paintShape.getX() + "</x>");
                out.println("<y>" + paintShape.getY() + "</y>");
                out.println("<width>" + paintShape.getWidth() + "</width>");
                out.println("<height>" + paintShape.getHeight() + "</height>");
                String color = paintShape.getColor().equals(Color.BLUE) ? "blue" : "red";
                out.println("<color>" + color + "</color>");
                String shape = (paintShape instanceof Rectangle) ? "rectangle" : "ellipse";
                out.println("<paint>" + shape + "</paint>");
                out.println("</shape>");
            }
            out.println("</shapes>");
            JOptionPane.showMessageDialog(null, "Slika '%s' je sačuvana".formatted(pictureName));
            paintWindow.clearPaintPanel();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
