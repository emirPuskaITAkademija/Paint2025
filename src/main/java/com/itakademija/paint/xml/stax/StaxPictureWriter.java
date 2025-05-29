package com.itakademija.paint.xml.stax;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

public class StaxPictureWriter implements PictureWriter {
    @Override
    public void write(String picturePath, List<PaintShape> paintShapes) {
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(picturePath));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("shapes");
            for (PaintShape paintShape : paintShapes) {
                xmlStreamWriter.writeStartElement("shape");
                //x
                xmlStreamWriter.writeStartElement("x");
                xmlStreamWriter.writeCharacters(paintShape.getX() + "");
                xmlStreamWriter.writeEndElement();
                //y
                xmlStreamWriter.writeStartElement("y");
                xmlStreamWriter.writeCharacters(paintShape.getY() + "");
                xmlStreamWriter.writeEndElement();
                //width
                xmlStreamWriter.writeStartElement("width");
                xmlStreamWriter.writeCharacters(paintShape.getWidth() + "");
                xmlStreamWriter.writeEndElement();
                //height
                xmlStreamWriter.writeStartElement("height");
                xmlStreamWriter.writeCharacters(paintShape.getHeight() + "");
                xmlStreamWriter.writeEndElement();
                //color
                xmlStreamWriter.writeStartElement("color");
                xmlStreamWriter.writeCharacters(paintShape.getColor().equals(Color.BLUE) ? "blue" : "red");
                xmlStreamWriter.writeEndElement();
                //paint
                xmlStreamWriter.writeStartElement("paint");
                xmlStreamWriter.writeCharacters(paintShape instanceof Ellipse ? "ellipse" : "rectangle");
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
