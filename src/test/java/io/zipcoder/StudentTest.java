package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StudentTest {

    @Test
    public void testCreateStudent() {

    }
    @Test
    public void testGetExamScores(){
        // Given
        String firstName = "Ash";
        String lastName = "Ketchup";
        Double[] examScores = {100.0,95.0,123.0,96.0};
        Student student = new Student(firstName, lastName, examScores);
        // When
        String output = student.getExamScores();
        String expectedScore = Arrays.toString(examScores);
        // Then
        System.out.println(output);
        Assert.assertEquals(expectedScore, output);
    }
    @Test
    public void testAddExamScore() {
        // Given
        String firstName = "Hubble";
        String lastName = "Tele";
        Double[] examScores = {};
        Student student = new Student(firstName,lastName,examScores);
        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();
        String expected = "[100.0]";
        // Then
        System.out.println(expected);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testSetExamScore() {
        // Given
        String firstName = "Mr.";
        String lastName = "Panda";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName,lastName,examScores);
        // When
        student.setExamScore(1, 150.0);
        String expected = "[150.0]";
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(expected, output);
    }
    @Test
    public void testGetAverageExamScore() {
        // Given
        String firstName = "Itsa me";
        String lastName = "Mario";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);
        // When
        Double expected = (double) ((100+150+250)/4);
        Double output = student.getAverageExamScore();
        // Then
        Assert.assertEquals(expected, output);
    }
    @Test
    public void testToString() {
        // Given
        String firstName = "T-";
        String lastName = "Rex";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        // When
        String expected = "Student Name: " + firstName + lastName + "\n" +
                "> Average Score: " + student.getAverageExamScore() + "\n" +
                "> Exam Scores: " + "\n" + student.getExamScores();

        String actual = student.toString();
        // Then
        Assert.assertEquals(expected, actual);
    }
}