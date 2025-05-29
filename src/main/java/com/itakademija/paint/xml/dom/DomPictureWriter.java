package com.itakademija.paint.xml.dom;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.File;
import java.util.List;

public class DomPictureWriter implements PictureWriter {
    @Override
    public void write(String picturePath, List<PaintShape> paintShapes) {
        Document document = createDocument(paintShapes);
        transferDocumentToFile(document, picturePath);
    }

    private Document createDocument(List<PaintShape> paintShapes) {
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

    private void transferDocumentToFile(Document document, String picturePath) {
        try {
            //transformaciju sadržaja u document preko nekakvih DOM transformera
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(picturePath));
            transformer.transform(domSource, streamResult);
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
