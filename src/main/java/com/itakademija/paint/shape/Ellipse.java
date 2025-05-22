package com.itakademija.paint.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends PaintShape {
    public Ellipse(int x, int y, Color color) {
        super(x, y, color);
    }

    public Ellipse(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }


    @Override
    public Shape createShape() {
        return new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());
    }
}
