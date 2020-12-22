package com.M_mehdi;

import java.util.Objects;

public class Teacher {
    private Subject subject;
    private String username;
    private String password;

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
        subject = new Subject();
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
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getUsername().equals(teacher.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(),getPassword());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
