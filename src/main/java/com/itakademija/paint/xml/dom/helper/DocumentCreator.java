package com.itakademija.paint.xml.dom.helper;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.util.List;
import java.util.function.Function;

public class DocumentCreator implements DocumentProcessor<List<PaintShape>, Document> {
    @Override
    public Document process(List<PaintShape> paintShapes) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element shapesElement = document.createElement("shapes");
            document.appendChild(shapesElement);
            for (PaintShape paintShape : paintShapes) {
                Element shapeElement = mapToElement(document, paintShape);
                shapesElement.appendChild(shapeElement);
            }
            return document;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Element mapToElement(Document document, PaintShape paintShape) {
        Element shapeElement = document.createElement("shape");
        //x
        Element xElement = document.createElement("x");
        xElement.setTextContent(paintShape.getX() + "");
        shapeElement.appendChild(xElement);
        //y
        Element yElement = document.createElement("y");
        yElement.setTextContent(paintShape.getY() + "");
        shapeElement.appendChild(yElement);
        //width
        Element widthElement = document.createElement("width");
        widthElement.setTextContent(paintShape.getWidth() + "");
        shapeElement.appendChild(widthElement);
        //height
        Element heightElement = document.createElement("height");
        heightElement.setTextContent(paintShape.getHeight() + "");
        shapeElement.appendChild(heightElement);
        //color
        Element colorElement = document.createElement("color");
        colorElement.setTextContent(paintShape.getColor().equals(Color.BLUE) ? "blue" : "red");
        shapeElement.appendChild(colorElement);
        //paint
        Element paintElement = document.createElement("paint");
        String paintElementContent = paintShape instanceof Ellipse ? "ellipse" : "rectangle";
        paintElement.setTextContent(paintElementContent);
        shapeElement.appendChild(paintElement);

        return shapeElement;
    }
}