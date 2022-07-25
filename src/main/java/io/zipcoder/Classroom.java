package io.zipcoder;

import java.util.*;

public class Classroom {

    Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double d = null;
        for (Student s : students) {
            d += s.getAverageExamScore();
        }
        return d / students.length;
    }

    public void addStudent(Student student) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        studentList.add(student);
        students = studentList.toArray(new Student[0]);
    }

    public void removeStudent(String firstName, String lastName) {
        for (Student s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                s = null;
            }
        }
        Arrays.sort(students);
    }

    public Student[] getStudentsByScore() {
        return null;
    }

}
