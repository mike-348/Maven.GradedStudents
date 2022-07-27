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
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
//        studentList.sort(Comparator.comparingDouble(Student::getAverageExamScore));;
        Collections.sort(studentList,
                Comparator.comparingDouble((Student s) -> -s.getAverageExamScore())
                        .thenComparing(s -> s.getLastName())
                        .thenComparing(s -> s.getFirstName()));
//        Collections.reverse(studentList);
        return studentList.toArray(new Student[0]);
    }

    public Map<String, Character> getGradebook() {
        Map<String, Character> gradeBook = new HashMap<>();
        for (Student s : students) {
            String name = s.getLastName() + ", " + s.getFirstName();
            if (getPercentile(s) >= 90) {
                gradeBook.put(name, 'A');
            } else if (getPercentile(s) < 90 && getPercentile(s) >= 71) {
                gradeBook.put(name, 'B');
            } else if (getPercentile(s) < 71 && getPercentile(s) >= 50) {
                gradeBook.put(name, 'C');
            } else if (getPercentile(s) < 50 && getPercentile(s) >= 11) {
                gradeBook.put(name, 'D');
            } else gradeBook.put(name, 'F');
        }
        return gradeBook;
    }

    public double getPercentile(Student student) {
//        percentile = Number of Values Below “x” / Total Number of Values × 100 https://www.cuemath.com/percentile-formula/
        double numBelow = 0.0;
        for (Student s : students) {
            if (s.getAverageExamScore() <= student.getAverageExamScore()) {
                numBelow++;
            }
        }
        int numStudents = students.length;
        double percentile = numBelow / numStudents;
        return percentile * 100;
    }



    public String toString() {
        return Arrays.toString(students);
    }
}

