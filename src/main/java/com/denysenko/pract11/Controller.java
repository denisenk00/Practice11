package com.denysenko.pract11;

import java.util.LinkedList;

public class Controller {
    public static void checkAverage(LinkedList<Student> studentList){
        for (Student student: studentList) {
            double average = student.getAverageMark();
            int n = 0;
            double sum = 0;
            for (Subject subject : student.getListOfSubject()) {
                sum += subject.getMark();
                n++;
            }
            double newAverage = sum / n;
            if (average != newAverage) student.setAverageMark(newAverage);
        }
    }
}
