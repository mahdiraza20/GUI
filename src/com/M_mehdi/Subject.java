package com.M_mehdi;

import java.lang.reflect.Array;

public class Subject {
    String name;
    int vahed;
    int capacity;
   int[] time ;
    public Subject() {
        time = new int[3];
        time[0] = 8;
        time[1] = 10;
        time[2] = 14;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVahed() {
        return vahed;
    }

    public void setVahed(int vahed) {
        this.vahed = vahed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int setTime(int i) {
        if (i >= 0 && i <= 2) {
            return time[i];
        }else return -1;

    }


}
