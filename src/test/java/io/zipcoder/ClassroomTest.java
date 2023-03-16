package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {
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

        // Then
//        System.out.println(output);
        Assert.assertEquals(examScores, output);
    }

}
