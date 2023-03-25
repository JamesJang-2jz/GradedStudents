package io.zipcoder;

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
        gradeBook.put('A',)


    }
    public HashMap<? , Student[]> setGrades(){

    }

}
