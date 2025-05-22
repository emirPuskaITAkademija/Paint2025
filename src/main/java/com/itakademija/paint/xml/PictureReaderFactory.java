package com.itakademija.paint.xml;

import com.itakademija.paint.xml.dom.DomPictureReader;
import com.itakademija.paint.xml.sax.SaxPictureReader;
import com.itakademija.paint.xml.stax.StaxPictureReader;

public enum PictureReaderFactory {

    SAX(new SaxPictureReader()),
    STAX(new StaxPictureReader()),
    DOM(new DomPictureReader());

    private final PictureReader pictureReader;

    PictureReaderFactory(PictureReader pictureReader) {
        this.pictureReader = pictureReader;
    }

    public PictureReader get() {
        return pictureReader;
    }
}
