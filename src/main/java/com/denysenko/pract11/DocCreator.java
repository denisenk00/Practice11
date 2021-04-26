package com.denysenko.pract11;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class DocCreator {
    public static void writeDocument(Document document, File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "group.dtd");
            transformer.transform(new DOMSource(document), new StreamResult(fos));
        } catch (Exception e) {
            System.err.println("Error while writing to file");
        }
    }

    public static Document createXMLDocument(LinkedList<Student> studentList) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = factory.newDocumentBuilder().newDocument();
            Element groupElement = document.createElement("group");
            for (Student a : studentList) {
                Element studentElement = document.createElement("student");
                studentElement.setAttribute("firstname", a.getFirstName());
                studentElement.setAttribute("lastname", a.getLastName());
                studentElement.setAttribute("groupnumber", a.getGroupNumber());
                for (Subject s : a.getListOfSubject()) {
                    studentElement.appendChild(createSubjectElement(document, s));
                }
                Element averageElement = document.createElement("average");
                averageElement.setTextContent(String.valueOf(a.getAverageMark()));
                studentElement.appendChild(averageElement);
                groupElement.appendChild(studentElement);
            }
            document.appendChild(groupElement);
            document.normalizeDocument();
            document.setXmlStandalone(true);
        } catch (Exception e) {
            System.err.println("Error while creating document");
        }
        return document;
    }

    private static Element createSubjectElement(Document document, Subject subject) {
        Element subjectElement = document.createElement("subject");
        subjectElement.setAttribute("title", subject.getTitle());
        subjectElement.setAttribute("mark", String.valueOf(subject.getMark()));
        return subjectElement;
    }


}
