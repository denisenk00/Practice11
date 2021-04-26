package com.denysenko.pract11;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;

public class DocParser {

    public static LinkedList<Student> getStudents(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new ErrorHandler());
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("student");
            LinkedList<Student> studentList = new LinkedList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                studentList.add(getOneStudent(nodeList.item(i)));
            }
            return studentList;
        } catch (Exception e) {
            System.err.println("Error while parsing document");
            return null;
        }
    }

    private static Student getOneStudent(Node node) {
        Student student = new Student();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            student.setFirstName(getAttributeValue("firstname", element));
            student.setLastName(getAttributeValue("lastname", element));
            student.setGroupNumber(getAttributeValue("groupnumber", element));
            NodeList subjectNodeList = element.getElementsByTagName("subject");
            LinkedList<Subject> subjectList = new LinkedList<>();
            for (int i = 0; i < subjectNodeList.getLength(); i++) {
                subjectList.add(getSubject(subjectNodeList.item(i)));
            }
            student.setListOfSubject(subjectList);
            if (getTagValue("average", element) != null) {
                student.setAverageMark(Double.valueOf(getTagValue("average", element)));
            }
        }
        return student;
    }

    private static Subject getSubject(Node node) {
        Subject subject = new Subject();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            subject.setTitle(getAttributeValue("title", element));
            subject.setMark(Integer.valueOf(getAttributeValue("mark", element)));
        }
        return subject;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0) return nodeList.item(0).getTextContent();
        else return null;
    }


    private static String getAttributeValue(String attribute, Element element) {
        Attr attr = element.getAttributeNode(attribute);
        return attr.getValue();
    }


}
