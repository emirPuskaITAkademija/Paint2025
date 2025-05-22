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
import java.util.List;

public class DomPictureReader implements PictureReader {
    @Override
    public List<PaintShape> read(String picturePath) {
        List<PaintShape> shapes = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(new File(picturePath));
            //shapes
            Element documentElement = document.getDocumentElement();
            NodeList nodeList = documentElement.getElementsByTagName("shape");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element shapeElement = (Element) node;
                    Element xElement = (Element) shapeElement.getElementsByTagName("x").item(0);
                    Element yElement = (Element) shapeElement.getElementsByTagName("y").item(0);
                    Element colorElement = (Element) shapeElement.getElementsByTagName("color").item(0);
                    Element paintElement = (Element) shapeElement.getElementsByTagName("paint").item(0);

                    Color color = colorElement.getTextContent().equalsIgnoreCase("blue") ? Color.BLUE : Color.RED;
                    PaintShape paintShape;
                    if (paintElement.getTextContent().equalsIgnoreCase("ellipse")) {
                        paintShape = new Ellipse(Integer.parseInt(xElement.getTextContent()), Integer.parseInt(yElement.getTextContent()), color);
                    } else {
                        paintShape = new Rectangle(Integer.parseInt(xElement.getTextContent()), Integer.parseInt(yElement.getTextContent()), color);
                    }
                    shapes.add(paintShape);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return shapes;
    }
}
