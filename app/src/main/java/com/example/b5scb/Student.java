package com.example.b5scb;

public class Student {
    String name;
    int  id;
    boolean isEligible;
    long   dob;

    public Student(String name, int id, boolean isEligible, long dob) {
        this.name = name;
        this.id = id;
        this.isEligible = isEligible;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }
}
