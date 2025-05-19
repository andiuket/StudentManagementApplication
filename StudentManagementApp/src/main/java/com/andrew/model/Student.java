package com.andrew.model;

import java.util.Objects;

public class Student {
    private int regNum;
    private String name;
    private String collegeName;
    private String city;
    private double percentage;

    public Student() {
    }

    public Student(String name, String collegeName, String city, double percentage) {
        this.name = name;
        this.collegeName = collegeName;
        this.city = city;
        this.percentage = percentage;
    }

    public Student(int regNum, String name, String collegeName, String city, double percentage) {
        this.regNum = regNum;
        this.name = name;
        this.collegeName = collegeName;
        this.city = city;
        this.percentage = percentage;
    }

    public int getRegNum() {
        return regNum;
    }

    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNum=" + regNum +
                ", name='" + name + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return regNum == student.regNum && Double.compare(percentage, student.percentage) == 0 && Objects.equals(name, student.name) && Objects.equals(collegeName, student.collegeName) && Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNum, name, collegeName, city, percentage);
    }
}
