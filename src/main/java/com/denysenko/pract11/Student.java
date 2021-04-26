package com.denysenko.pract11;

import java.util.LinkedList;

public class Student {
    private String firstName;
    private String lastName;
    private String groupNumber;
    private double averageMark;
    private LinkedList<Subject> listOfSubject;

    public Student(){}

    public Student(String firstName, String lastName, String groupNumber, double averageMark, LinkedList<Subject> listOfSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.averageMark = averageMark;
        this.listOfSubject = listOfSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public LinkedList<Subject> getListOfSubject() {
        return listOfSubject;
    }

    public void setListOfSubject(LinkedList<Subject> listOfSubject) {
        this.listOfSubject = listOfSubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", averageMark=" + averageMark +
                ", listOfSubject=" + listOfSubject +
                '}';
    }
}
