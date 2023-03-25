package io.zipcoder;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }
    public Classroom(Student[] students){
        this.students = students;
    }
    public Classroom() {
        students = new Student[30];
    }
    public Student[] getStudents() {
        return students;
    }
    public double getAverageExamScore() {
        double sum = 0;
        for (Student stu: students) {
            sum += stu.getAverageExamScore();
        }
        return sum/students.length;
    }
    public void addStudent(Student student) {
        int i = 0;
        for (Student s : students) {
            if (s == null) {
                students[i] = student;
                break;
            } i++;
        }
    }
    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(students));
        for (Student s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                studentList.remove(s);
            }
        }   students = studentList.toArray(new Student[0]);
    }
    public Student[] getStudentsByScore(){
        //        studentSorted.add(students);
//        ArrayList<Student> studentSorted = new ArrayList<>(Arrays.asList(students));
//        Collections.sort(studentSorted);
//        return studentSorted.toArray();
        Arrays.sort(students);
        return students;
    }
    public Map< Character, Student[]> getGradeBook() {
        HashMap<Character, Student[]> gradeBook = new HashMap<>();
        MultiMap gb = new MultiValueMap();
        Student[] studentPlacement = new Student[0];
        List<Student> studentsA = new ArrayList<>();
        gradeBook.put('A',null);
        gradeBook.put('B',null);
        gradeBook.put('C',null);
        gradeBook.put('D',null);
        gradeBook.put('F',null);

        double avgExam = getAverageExamScore();

        for (Student st : students) {
            if (st.getAverageExamScore() > avgExam * 0.9) {
                gb.put('A', st);
            } else if ()
        }



    }
    public HashMap<? , Student[]> setGrades(){

    }

}
