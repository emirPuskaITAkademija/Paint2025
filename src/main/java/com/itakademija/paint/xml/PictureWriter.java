package com.itakademija.paint.xml;

import com.itakademija.paint.shape.PaintShape;

import java.util.List;

public interface PictureWriter {
    String PICTURE_EXTENSIONS = ".nfs";

    void write(String picturePath, List<PaintShape> paintShapes);
}
