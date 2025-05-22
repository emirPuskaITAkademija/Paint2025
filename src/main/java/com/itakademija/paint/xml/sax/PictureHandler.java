package com.itakademija.paint.xml.sax;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.*;
import java.util.List;

public class PictureHandler extends DefaultHandler {
    private int x;
    private boolean xOpen;
    private int y;
    private boolean yOpen;
    private int width;
    private boolean widthOpen;
    private int height;
    private boolean heightOpen;
    private String color;
    private boolean colorOpen;
    private String paint;
    private boolean paintOpen;

    private final List<PaintShape> paintShapes;

    public PictureHandler(List<PaintShape> paintShapes) {
        this.paintShapes = paintShapes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("x".equalsIgnoreCase(qName)) {
            xOpen = true;
        } else if ("y".equalsIgnoreCase(qName)) {
            yOpen = true;
        } else if ("width".equalsIgnoreCase(qName)) {
            widthOpen = true;
        } else if ("height".equalsIgnoreCase(qName)) {
            heightOpen = true;
        } else if ("color".equalsIgnoreCase(qName)) {
            colorOpen = true;
        } else if ("paint".equalsIgnoreCase(qName)) {
            paintOpen = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (xOpen) {
            x = Integer.parseInt(String.valueOf(ch, start, length));
            xOpen = false;
        } else if (yOpen) {
            y = Integer.parseInt(String.valueOf(ch, start, length));
            yOpen = false;
        } else if (widthOpen) {
            width = Integer.parseInt(String.valueOf(ch, start, length));
            widthOpen = false;
        } else if (heightOpen) {
            height = Integer.parseInt(String.valueOf(ch, start, length));
            heightOpen = false;
        } else if (colorOpen) {
            color = String.valueOf(ch, start, length);
            colorOpen = false;
        } else if (paintOpen) {
            paint = String.valueOf(ch, start, length);
            paintOpen = false;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("shape".equalsIgnoreCase(qName)) {
            PaintShape paintShape;
            Color paintColor = "blue".equalsIgnoreCase(color) ? Color.BLUE : Color.RED;
            if (paint.equalsIgnoreCase("ellipse")) {
                paintShape = new Ellipse(x, y, width, height, paintColor);
            } else {
                paintShape = new Rectangle(x, y, width, height, paintColor);
            }
            paintShapes.add(paintShape);
        }
    }
}
