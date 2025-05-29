package com.itakademija.paint.xml.stax;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;
import com.itakademija.paint.xml.PictureReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.awt.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaxPictureReader implements PictureReader {
    @Override
    public List<PaintShape> read(String picturePath) {
        try {
            List<PaintShape> paintShapes = new ArrayList<>();
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileReader(picturePath));
            while (xmlStreamReader.hasNext()) {
                //otvarajući element neki( <x> <y>, <color>..
                // content ili sadržaj od x, y, color
                //zatvarajući neki (</x>, </y>..)
                int typeOfElement = xmlStreamReader.next();
                PaintShape paintShape = mapToPaintShape(xmlStreamReader, typeOfElement);
                paintShapes.add(paintShape);
            }
            return paintShapes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }
    
    
    private PaintShape mapToPaintShape(XMLStreamReader xmlStreamReader, int typeOfElement){
        boolean openX = false;
        String x = "";
        boolean openY = false;
        String y = "";
        boolean openWidth = false;
        String width;
        boolean openHeight = false;
        String height;
        boolean openColor = false;
        String color = "";
        boolean openPaint = false;
        String paint = "";
        PaintShape paintShape = null;
        switch (typeOfElement) {
            case XMLStreamReader.START_ELEMENT:
                if ("x".equals(xmlStreamReader.getName().toString())) {
                    openX = true;
                } else if ("y".equals(xmlStreamReader.getName().toString())) {
                    openY = true;
                } else if ("width".equals(xmlStreamReader.getName().toString())) {
                    openWidth = true;
                } else if ("height".equals(xmlStreamReader.getName().toString())) {
                    openHeight = true;
                } else if ("color".equals(xmlStreamReader.getName().toString())) {
                    openColor = true;
                } else if ("paint".equals(xmlStreamReader.getName().toString())) {
                    openPaint = true;
                }
                break;
            case XMLStreamReader.CHARACTERS:
                if (openX) {
                    x = xmlStreamReader.getText();
                } else if (openY) {
                    y = xmlStreamReader.getText();
                } else if (openWidth) {
                    width = xmlStreamReader.getText();
                } else if (openHeight) {
                    height = xmlStreamReader.getText();
                } else if (openColor) {
                    color = xmlStreamReader.getText();
                } else if (openPaint) {
                    paint = xmlStreamReader.getText();
                }
                break;
            case XMLStreamReader.END_ELEMENT:
                if ("x".equals(xmlStreamReader.getName().toString())) {
                    openX = false;
                } else if ("y".equals(xmlStreamReader.getName().toString())) {
                    openY = false;
                } else if ("width".equals(xmlStreamReader.getName().toString())) {
                    openWidth = false;
                } else if ("height".equals(xmlStreamReader.getName().toString())) {
                    openHeight = false;
                } else if ("color".equals(xmlStreamReader.getName().toString())) {
                    openColor = false;
                } else if ("paint".equals(xmlStreamReader.getName().toString())) {
                    openPaint = false;
                } else if ("shape".equalsIgnoreCase(xmlStreamReader.getName().toString())) {
                    Color colorAwt = "BLUE".equalsIgnoreCase(color) ? Color.BLUE : Color.RED;
                    if ("ellipse".equalsIgnoreCase(paint)) {
                        paintShape = new Ellipse(Integer.parseInt(x), Integer.parseInt(y), colorAwt);
                    } else {
                        paintShape = new Rectangle(Integer.parseInt(x), Integer.parseInt(y), colorAwt);
                    }
                }
                break;
        }
        return paintShape;
    }
}
