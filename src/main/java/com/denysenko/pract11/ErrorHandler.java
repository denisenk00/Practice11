package com.denysenko.pract11;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ErrorHandler implements org.xml.sax.ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Error: " + exception.getMessage());
        System.exit(1);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("Error: " + exception.getMessage());
        System.exit(1);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("Error: " + exception.getMessage());
        System.exit(1);
    }
}
