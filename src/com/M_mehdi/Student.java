package com.M_mehdi;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private Double average;
    private Double cash;
    private ArrayList<Subject> subjects;
    private String username;
    private String password;
    private String cardInfoNum;
    private String cardInfoPAss;

    public String getCardInfoNum() {
        return cardInfoNum;
    }

    public void setCardInfoNum(String cardInfoNum) {
        this.cardInfoNum = cardInfoNum;
    }

    public String getCardInfoPAss() {
        return cardInfoPAss;
    }

    public void setCardInfoPAss(String cardInfoPAss) {
        this.cardInfoPAss = cardInfoPAss;
    }

    public Student(String username, String password) {
        average = 0.0;
        cash = 0.0;
        this.username = username;
        this.password = password;
        subjects = new ArrayList<>();
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
    public void addSubject(Subject subject) {
        subjects.add(subject);
        subjects.add(subject);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getUsername().equals(student.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
    public int hashCodeCard() {
        return Objects.hash(getCardInfoNum(), getCardInfoPAss());
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
