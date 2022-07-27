package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class ClassroomTest {

    public void setUp() {
        List<Student> studentList = new ArrayList<>();
        Student mike = new Student("mike", "martin", new Double[]{85.00, 95.00});
        Student kyle = new Student("kyle", "welch", new Double[]{100.00, 100.00});
        Student myah = new Student("myah", "downes", new Double[]{95.00, 100.00});
        studentList.add(kyle); //100
        studentList.add(myah); //95
        studentList.add(mike); //90
        Student[] studentArray = studentList.toArray(new Student[0]);
    }

    @Test
    public void getStudentsByScoreTest() {
        Student mike = new Student("mike", "downes", new Double[]{85.00, 95.00});
        Student kyle = new Student("kyle", "welch", new Double[]{100.00, 100.00});
        Student myah = new Student("myah", "downes", new Double[]{95.00, 85.00});

        Classroom cl = new Classroom(0);
        cl.addStudent(kyle);
        cl.addStudent(mike);
        cl.addStudent(myah);

        Assert.assertEquals(3, cl.getStudents().length);

        System.out.println(Arrays.toString(cl.getStudentsByScore()));
    }

    @Test
    public void getStudentsByScoreTest1() {
        Student mike = new Student("mike", "downes", new Double[]{85.00, 95.00});
        Student kyle = new Student("kyle", "welch", new Double[]{100.00, 100.00});
        Student myah = new Student("myah", "downes", new Double[]{95.00, 85.00});

        Classroom cl = new Classroom(0);
        cl.addStudent(kyle);
        cl.addStudent(mike);
        cl.addStudent(myah);

        String strOutput = "[Student Name: kyle welch\n" +
                "Average Score: 100.0\n" +
                "Exam Scores: \n" +
                "        Exam 0 -> 100.0\n" +
                "        Exam 1 -> 100.0\n" +
                ", Student Name: mike downes\n" +
                "Average Score: 90.0\n" +
                "Exam Scores: \n" +
                "        Exam 0 -> 85.0\n" +
                "        Exam 1 -> 95.0\n" +
                ", Student Name: myah downes\n" +
                "Average Score: 90.0\n" +
                "Exam Scores: \n" +
                "        Exam 0 -> 95.0\n" +
                "        Exam 1 -> 85.0\n" +
                "]";

        Student[] output = {kyle, mike, myah};

        Assert.assertEquals(output, cl.getStudentsByScore());
    }

    @Test
    public void getPercentileTest() {
        Student daph = new Student("daphne", "blake", new Double[]{95.00, 95.00});
        Student shaggy = new Student("shaggy", "rogers", new Double[]{40.00, 80.00});
        Student fred = new Student("fred", "jones", new Double[]{65.00, 85.00});
        Student scoob = new Student("scooby", "doo", new Double[]{80.00, 40.00});
        Student velma = new Student("velma", "dinkley", new Double[]{100.00, 100.00});

        Classroom cl = new Classroom(0);
        cl.addStudent(daph); //95
        cl.addStudent(shaggy); //60
        cl.addStudent(fred); //75
        cl.addStudent(scoob); //60
        cl.addStudent(velma); //100

        System.out.println(shaggy.getAverageExamScore());
        System.out.println(cl.getPercentile(scoob));
    }
}
