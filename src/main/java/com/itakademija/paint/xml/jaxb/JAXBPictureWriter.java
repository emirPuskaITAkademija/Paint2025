package com.itakademija.paint.xml.jaxb;

import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;
import com.itakademija.paint.xml.PictureWriter;
import com.itakademija.paint.xml.jaxb.model.ObjectFactory;
import com.itakademija.paint.xml.jaxb.model.Shape;
import com.itakademija.paint.xml.jaxb.model.Shapes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.awt.*;
import java.io.File;
import java.util.List;

public class JAXBPictureWriter implements PictureWriter {

    @Override
    public void write(String picturePath, List<PaintShape> paintShapes) {
        try {
            ObjectFactory objectFactory = new ObjectFactory();
            Shapes shapes = objectFactory.createShapes();
            List<Shape> shapeList = paintShapes
                    .stream()
                    .map(this::transform)
                    .toList();
            shapes.getShape().addAll(shapeList);
            JAXBContext context = JAXBContext.newInstance(Shapes.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(shapes, new File(picturePath));
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }
    }

    private Shape transform(PaintShape paintShape) {
        Shape shape = new Shape();
        shape.setX(paintShape.getX());
        shape.setY(paintShape.getY());
        shape.setHeight(paintShape.getHeight());
        shape.setWidth(paintShape.getWidth());
        shape.setColor(paintShape.getColor().equals(Color.BLUE) ? "blue" : "red");
        shape.setPaint((paintShape instanceof Rectangle) ? "rectangle" : "ellipse");
        return shape;
    }
}
