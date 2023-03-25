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
    public MultiMap getGradeBook() {
        HashMap<Character, Student[]> gradeBook = new HashMap<>();
        MultiMap gb = new MultiValueMap();
//        gradeBook.put('A',null);
//        gradeBook.put('B',null);
//        gradeBook.put('C',null);
//        gradeBook.put('D',null);
//        gradeBook.put('F',null);

        double avgExam = getAverageExamScore();

        for (Student st : students) {
            if (st.getAverageExamScore() > avgExam * 0.9) {
                gb.put("A", st);
            } else if (st.getAverageExamScore() > avgExam * 0.71){
                gb.put('B', st);
            } else if (st.getAverageExamScore() > avgExam * 0.5){
                gb.put('C', st);
            } else if (st.getAverageExamScore() > avgExam * 0.11){
                gb.put('D', st);
            } else {
                gb.put('F', st);
            }
        }
        return gb;

    }
    public HashMap<Character, Student[]> setGrades(){
        HashMap<Character, Student[]> map = new HashMap<>();
        map.put('A', new Student[]{});
        map.put('B', new Student[]{});
        map.put('C', new Student[]{});
        map.put('D', new Student[]{});
        map.put('F', new Student[]{});
        return map;
    }

}
