package com.itakademija.paint.xml.dom;

import com.itakademija.paint.shape.PaintShape;
import com.itakademija.paint.xml.PictureWriter;
import com.itakademija.paint.xml.dom.helper.DocumentCreator;
import com.itakademija.paint.xml.dom.helper.DocumentTransferExecutor;

import java.util.List;

public class DomPictureWriter implements PictureWriter {
    @Override
    public void write(String picturePath, List<PaintShape> paintShapes) {
        new DocumentCreator()//
                .afterThat(new DocumentTransferExecutor(picturePath))//
                .process(paintShapes);
    }
}
