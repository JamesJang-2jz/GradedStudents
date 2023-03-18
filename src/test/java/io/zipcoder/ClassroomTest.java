package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.lang.invoke.CallSite;
import java.util.Arrays;
import java.util.Calendar;

public class ClassroomTest {
    @Test
    public void testGetAverageExamScore() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Student s1 = new Student("Yoshi ", "one", s1Scores);
        Student s2 = new Student("Munchakoopas ", "two", s2Scores);
        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);
        // When®
        double expected = 125.0;
        double actual = classroom.getAverageExamScore();
        // Then
        Assert.assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testAddStudent() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0 };
        String firstName = "Saiyan";
        String lastName = "Trunks";
        Student student = new Student(firstName, lastName, examScores);
        // When
        Student[] preEnrollment = new Student[0];
        Student[] postEnrollment = classroom.getStudents();

        classroom.addStudent(student);

        Student[] expected = new Student[] {student};
        Student[] actual = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        Assert.assertEquals(expected, actual);

        System.out.println("=========");
        System.out.println(preEnrollmentAsString);
        System.out.println("=========");
        System.out.println(postEnrollmentAsString);
    }
    @Test
    public void testRemoveStudent() {
        // Given
        String firstName = "Pikachu";
        String lastName = "Shocked face";
        Double[] examScores = {100.0, 123.0};
        Student[] expected = new Student[0];
        Student student = new Student(firstName, lastName, examScores);

        Student[] students = {student};
        Classroom classroom = new Classroom(students);

        // When
        classroom.removeStudent(student.getFirstName(), student.getLastName());
        Student[] actual = new Student[0];
        // Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetStudentsByScore() {
        // Given

        // When

        // Then
        

    }



}
