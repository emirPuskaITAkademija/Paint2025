package com.itakademija.paint.xml.jaxb;

import com.itakademija.paint.shape.Ellipse;
import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.shape.Rectangle;
import com.itakademija.paint.xml.PictureReader;
import com.itakademija.paint.xml.jaxb.model.Shape;
import com.itakademija.paint.xml.jaxb.model.Shapes;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.awt.*;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class JAXBPictureReader implements PictureReader {
    @Override
    public List<PaintShape> read(String picturePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Shapes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Shapes shapes = (Shapes) unmarshaller.unmarshal(new File(picturePath));
            return shapes
                    .getShape()
                    .stream()
                    .map(this::transform)
                    .toList();
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    private PaintShape transform(Shape shape) {
        Color color = shape.getColor().equalsIgnoreCase("blue") ? Color.BLUE : Color.RED;
        return shape.getPaint().equalsIgnoreCase("ellipse") ?
                new Ellipse(shape.getX(), shape.getY(), color) :
                new Rectangle(shape.getX(), shape.getY(), color);
    }
}
