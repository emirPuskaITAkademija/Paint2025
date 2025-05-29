package com.itakademija.paint.xml.dom.helper;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.function.Function;

public class DocumentTransferExecutor implements DocumentProcessor<Document, Boolean> {
    private final String picturePath;

    public DocumentTransferExecutor(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public Boolean process(Document document) {
        try {
            //transformaciju sadržaja u document preko nekakvih DOM transformera
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(picturePath));
            transformer.transform(domSource, streamResult);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
