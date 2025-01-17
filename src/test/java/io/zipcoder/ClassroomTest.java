package io.zipcoder;

import org.apache.commons.collections.MultiMap;
import org.junit.Assert;
import org.junit.Test;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

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
        Double[] examScores1 = {150.0, 250.0, 133.0};
        Double[] examScores2 = {71.0, 56.0, 65.0};
        Double[] examScores3 = {72.0, 155.0, 45.0};
        Student student1 = new Student(null, null, examScores1);
        Student student2 = new Student(null, null, examScores2);
        Student student3 = new Student(null, null, examScores3);
        // When
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student1, student3, student2};
        Student[] actual = classroom.getStudentsByScore();
        // Then
        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetGradeBook(){
        // Given
        Double[] examScores1 = {90.0};
        Double[] examScores2 = {80.0};
        Double[] examScores3 = {75.0};
        Double[] examScores4 = {65.0};
        Double[] examScores5 = {50.0};
        Double[] examScores6 = {40.0};
        Double[] examScores7 = {35.0};
        Double[] examScores8 = {20.0};
        Double[] examScores9 = {4.0};

        Student student1 = new Student("Cat", "Bob", examScores1);
        Student student2 = new Student("Dog", "Doggo", examScores2);
        Student student3 = new Student("Bird", "Pidgey", examScores3);
        Student student4 = new Student("Doug", "Pug", examScores4);
        Student student5 = new Student("Leo", "Lion", examScores5);
        Student student6 = new Student("Tom", "turtle", examScores6);
        Student student7 = new Student("Zion", "Lion", examScores7);
        Student student8 = new Student("Po", "panda", examScores8);
        Student student9 = new Student("F", "Frog", examScores9);
        // When
        Classroom classroom = new Classroom(new Student[] {student1, student2, student3, student4, student5, student6, student7, student8, student9});
        Student[] A = new Student[]{student1, student2, student3, student4, student5};
        Student[] B = new Student[]{student6};
        Student[] C = new Student[]{student7};
        Student[] D = new Student[]{student8};
        Student[] F = new Student[]{student9};

        Map<Character, ArrayList<Student>> gb = classroom.getGradeBook();
        System.out.println(Arrays.toString(A));
        // Then
        Assert.assertArrayEquals(A, gb.get('A').toArray());
    }


}
