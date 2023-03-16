package io.zipcoder;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private String firstName;
    private String lastName;
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Double> examScores = new ArrayList<Double>();

    public Student(String first, String last, Double[] testScores) {
        this.firstName = first;
        this.lastName = last;
        Collections.addAll(examScores, testScores);
    }
    public void setFirstName(String first){
        this.firstName = first;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String last) {
        this.lastName = last;
    }
    public String getLastName() {
        return lastName;
    }
    public Double getNumberOfExamsTaken() {
        return (double) examScores.size();
    }
    public ArrayList<Double> getExamScores() {
        
        return examScores;
    }




}
