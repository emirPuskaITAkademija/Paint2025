package com.itakademija.paint.xml.sax;

import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;
import com.itakademija.paint.xml.PictureWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaxPictureWriter implements PictureWriter {

    @Override
    public void write(String picturePath, List<PaintShape> paintShapes) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(picturePath))) {
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<shapes>");

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
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
