package com.itakademija.paint.gui.settings;

import com.itakademija.paint.gui.PaintWindow;
import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {

    private final List<PaintShape> paintShapes = new ArrayList<>();


    public PaintPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new DrawListener());
        addMouseMotionListener(new DrawListener());
    }

    public List<PaintShape> getPaintShapes() {
        return paintShapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D - novija klasa koja je kompatibilna sa starom verzijom
        Graphics2D g2d = (Graphics2D) g;
        for(PaintShape paintShape : paintShapes) {
            g2d.setColor(paintShape.getColor());//java.awt.Color
            g2d.fill(paintShape.createShape());//java.awt.Shape -> java.awt.Rectangle, java.awt.Ellipse
        }
    }

    public void clear() {
        paintShapes.clear();
        repaint();
    }


    private class DrawListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            reactOnDrawing(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            reactOnDrawing(e);
        }

        private void reactOnDrawing(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            PaintWindow paintWindow = PaintWindow.instance();
            Color color = paintWindow.isBlueColorSelected() ? Color.BLUE: Color.RED;
            PaintShape paintShape;
            if(paintWindow.isRectangleShapeSelected()){
                paintShape = new Rectangle(x, y, color);
            }else{
                paintShape = new Ellipse(x, y, color);
            }
            paintShapes.add(paintShape);
            repaint();
        }
    }
}
