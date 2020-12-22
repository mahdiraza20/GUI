package com.M_mehdi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Admin {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private String username;
    private String password;
    private HashMap<String,Integer> food;

    public Admin(String username, String password) {
        food = new HashMap<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        this.username = username;
        this.password = password;
    }

    public Student getStudents(int i) {
        return students.get(i);
    }
    public void addStudents(Student student) {
        students.add(student);
    }
    public void addTeachers(Teacher teacher) {
        teachers.add(teacher);
    }
    public Teacher getTeachers(int i) {
        return teachers.get(i);
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
    public int getStudentsSize() { return students.size(); }
    public int getTeachersSize() { return teachers.size(); }
    public HashMap<String, Integer> getFood() {
        return food;
    }
    public void setFood(String name, int price) {
        food.put(name,price);
    }
    public void removeFood(String esm) {
        food.remove(esm);
    }
}
