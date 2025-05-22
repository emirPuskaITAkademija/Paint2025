package com.itakademija.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NoteHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Krenulo je čitanje XML note.xml...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Otvoren je XML element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Pročitan je XML sadržaj : " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Zatvorne je XML element: " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Završilo je čitanje note.xml...");
    }
}
