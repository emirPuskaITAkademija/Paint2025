package com.itakademija.paint.shape;

import java.awt.*;

public abstract class PaintShape {
    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_HEIGHT = 20;

    private int x;
    private int y;
    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    //java.awt.Color
    private Color color;

    public PaintShape(int x, int y, Color color) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, color);
    }

    public PaintShape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //java.awt.Shape
    public abstract Shape createShape();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
