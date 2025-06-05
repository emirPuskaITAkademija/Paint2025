package com.itakademija.paint.xml;

import com.itakademija.paint.xml.dom.DomPictureWriter;
import com.itakademija.paint.xml.jaxb.JAXBPictureWriter;
import com.itakademija.paint.xml.sax.SaxPictureWriter;
import com.itakademija.paint.xml.stax.StaxPictureWriter;

public enum PictureWriterFactory {

    SAX(new SaxPictureWriter()),
    STAX(new StaxPictureWriter()),
    DOM(new DomPictureWriter()),
    JAXB(new JAXBPictureWriter());

    private final PictureWriter pictureWriter;

    PictureWriterFactory(PictureWriter pictureWriter) {
        this.pictureWriter = pictureWriter;
    }

    public PictureWriter get() {
        return pictureWriter;
    }
}
