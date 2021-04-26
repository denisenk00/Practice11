package com.denysenko.pract11;

import org.w3c.dom.Document;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String nameInputFile;
        File inputFile = null;
        boolean ok = false;
        do {
            System.out.print("Enter name of the input file: ");
            nameInputFile = scanner.next();
            inputFile = new File(nameInputFile);
            if(inputFile.exists()) ok = true;
            else{
                System.out.println("File was not found! Enter file name again...");
                scanner.nextLine();
            }
        }while (ok == false);
        System.out.print("Enter name of the output file: ");
        String nameOutputFile = scanner.next();
        LinkedList<Student> studentsList = DocParser.getStudents(inputFile);
        Controller.checkAverage(studentsList);
        File outputFile = new File(nameOutputFile);
        DocCreator.writeDocument(DocCreator.createXMLDocument(studentsList), outputFile);
        System.out.println("Check passed successfully\nResults in the file: " + nameOutputFile);
    }

}
