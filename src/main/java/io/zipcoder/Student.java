package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String s = "Exam Scores: \n";
        for (int i = 0; i < examScores.size(); i++) {
            s += "        Exam " + i + " -> " + examScores.get(i) + "\n";
        }
        System.out.print(s);
        return s;
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScores(int examNumber, double newScore) {
        int examIndex = examNumber - 1;
        examScores.set(examIndex, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0;
        for (Double d : examScores) {
            sum += d;
        }
        return sum / examScores.size();
    }

    public String toString() {
        String str = "Student Name: " + getFirstName() + " " + getLastName() + "\n";
        str += "Average Score: " + getAverageExamScore() + "\n";
        str += getExamScores();
        return str;
    }


    public static void main (String[] args) {

    }

}
