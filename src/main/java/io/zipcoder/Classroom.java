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
    public Map<Character, ArrayList<Student>> getGradeBook() {
        HashMap<Character, ArrayList<Student>> gradeBook = new HashMap<>();
        gradeBook.put('A',new ArrayList<Student>());
        gradeBook.put('B',new ArrayList<Student>());
        gradeBook.put('C',new ArrayList<Student>());
        gradeBook.put('D',new ArrayList<Student>());
        gradeBook.put('F',new ArrayList<Student>());
//        MultiMap gb = new MultiValueMap();


        double avgExam = getAverageExamScore();

        for (Student st : students) {
            if (st.getAverageExamScore() > avgExam * 0.9) {
                gradeBook.get('A').add(st);
            } else if (st.getAverageExamScore() > avgExam * 0.71){
                gradeBook.get('B').add(st);
            } else if (st.getAverageExamScore() > avgExam * 0.5){
                gradeBook.get('C').add(st);
            } else if (st.getAverageExamScore() > avgExam * 0.11){
                gradeBook.get('D').add(st);
            } else if (st.getAverageExamScore() < avgExam * 0.11){
                gradeBook.get('F').add(st);
            }
        }
        return gradeBook;

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
