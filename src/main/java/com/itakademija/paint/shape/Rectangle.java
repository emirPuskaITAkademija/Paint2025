package com.itakademija.paint.shape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends PaintShape{
    public Rectangle(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public Shape createShape() {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
    }
}
