package com.itakademija.paint.xml;

import com.itakademija.paint.shape.PaintShape;

import java.util.List;

public interface PictureReader {
    List<PaintShape> read(String picturePath);
}
