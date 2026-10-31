package org.example;

public class Course {
    private String name;
    private int duration;
    private int students;

    static private int totalCourses;
    static private int totalStudents;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int d) {
        duration = d;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int s) {
        totalStudents -= students;
        students = s;
        totalStudents += students;
    }

    public Course(String n, int d, int s) {
        setName(n);
        setDuration(d);
        setStudents(s);
        totalCourses++;
    }

    static public double getAverageStudents() {
        return (double) totalStudents / totalCourses;
    }

}
