package com.itakademija.paint.xml.sax;

import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SaxPictureReader implements PictureReader {
    @Override
    public List<PaintShape> read(String picturePath) {
        List<PaintShape> paintShapes = new ArrayList<>();
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            PictureHandler pictureHandler = new PictureHandler(paintShapes);
            saxParser.parse(picturePath, pictureHandler);
        }catch (Exception exc){
            System.err.println(exc.getMessage());
        }
        return paintShapes;
    }
}
