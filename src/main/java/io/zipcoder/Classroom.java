package io.zipcoder;

import javax.swing.plaf.IconUIResource;
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
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
//        studentList.sort(Comparator.comparingDouble(Student::getAverageExamScore));;
        Collections.sort(studentList,
                Comparator.comparingDouble((Student s) -> -s.getAverageExamScore())
                        .thenComparing(s -> s.getLastName())
                        .thenComparing(s -> s.getFirstName()));
//        Collections.reverse(studentList);
        return studentList.toArray(new Student[0]);
    }

    public HashMap getGradebook() {
        List<Student> percentiles = new ArrayList<>(Arrays.asList(students));
        return new HashMap();
    }

    public Integer getPercentile(Student student) {
//        percentile = Number of Values Below “x” / Total Number of Values × 100 https://www.cuemath.com/percentile-formula/
        int numBelow = 0;
        for (Student s : students) {
            if (student.getAverageExamScore() >= s.getAverageExamScore()) {
                numBelow++;
            }
        }
        return (numBelow / students.length) * 100;
    }



    public String toString() {
        return Arrays.toString(students);
    }
}

