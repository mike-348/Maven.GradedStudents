package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void setFirstNameTest() {
        Double[] examScores = {30.00, 95.00, 85.00};
        Student s = new Student("johnny", "bravo", examScores);

        s.setFirstName("mikey");

        Assert.assertEquals("mikey", s.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        Double[] examScores = {70.10, 75.00, 50.00};
        Student s = new Student("johnny", "cash", examScores);

        s.setLastName("flame");

        Assert.assertEquals("flame", s.getLastName());
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        Double[] examScores = {100.00};
        Student s = new Student("kyle", "welch", examScores);

        Assert.assertEquals(1, (double) s.getNumberOfExamsTaken(), .001);
    }

    @Test
    public void getExamScoresTest () {
        Double[] examScores = {100.00, 75.00, 89.50};
        Student s = new Student("mike", "martin", examScores);

        String output = "Exam Scores: \n" +
                "        Exam 0 -> 100.0\n" +
                "        Exam 1 -> 75.0\n" +
                "        Exam 2 -> 89.5\n";

        Assert.assertEquals(output, s.getExamScores());
    }

    @Test
    public void addExamScoreTest() {
        Double[] examScores = {100.00, 75.00, 89.50};
        Student s = new Student("mike", "martin", examScores);

        s.addExamScore(63.00);

        Assert.assertEquals(4, (double) s.getNumberOfExamsTaken(), .001);
    }

    @Test
    public void setExamScoreTest() {
        Double[] examScores = {100.00, 75.00, 89.50, 63.00};
        Student s = new Student("mike", "martin", examScores);

        s.setExamScores(4, 100.00);

        Assert.assertEquals(100, (double) s.examScores.get(s.examScores.size()-1), .001);
    }

    @Test
    public void toStringTest() {
        Double[] examScores = {100.00, 75.00, 89.50, 100.00};
        Student s = new Student("mike", "martin", examScores);


        String str = "Student Name: mike martin\n" +
                "Average Score: 91.125\n" +
                "Exam Scores: \n" +
                "        Exam 0 -> 100.0\n" +
                "        Exam 1 -> 75.0\n" +
                "        Exam 2 -> 89.5\n" +
                "        Exam 3 -> 100.0\n";

        Assert.assertEquals(str, s.toString());
    }

}