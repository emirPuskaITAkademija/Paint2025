package com.itakademija.paint.xml.dom;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;
import com.itakademija.paint.xml.PictureReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DomPictureReader implements PictureReader {
    @Override
    public List<PaintShape> read(String picturePath) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(picturePath));
            Element documentElement = document.getDocumentElement();
            NodeList nodeList = documentElement.getElementsByTagName("shape");
            return mapToShapes(nodeList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    private List<PaintShape> mapToShapes(NodeList shapeNodeList) {
        List<PaintShape> shapes = new ArrayList<>();
        for (int i = 0; i < shapeNodeList.getLength(); i++) {
            Node node = shapeNodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element shapeElement = (Element) node;
                PaintShape paintShape = mapToPaintShape(shapeElement);
                shapes.add(paintShape);
            }
        }
        return shapes;
    }

    private PaintShape mapToPaintShape(Element shapeElement) {
        Element xElement = (Element) shapeElement.getElementsByTagName("x").item(0);
        Element yElement = (Element) shapeElement.getElementsByTagName("y").item(0);
        Element colorElement = (Element) shapeElement.getElementsByTagName("color").item(0);
        Element paintElement = (Element) shapeElement.getElementsByTagName("paint").item(0);

        Color color = colorElement.getTextContent().equalsIgnoreCase("blue") ? Color.BLUE : Color.RED;
        String paintType = paintElement.getTextContent();
        boolean isEllipse = paintType.equalsIgnoreCase("isEllipse");
        int x = Integer.parseInt(xElement.getTextContent());
        int y = Integer.parseInt(yElement.getTextContent());

        return isEllipse ? new Ellipse(x, y, color) : new Rectangle(x, y, color);
    }
}
