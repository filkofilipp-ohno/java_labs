package org.example;

public class Student {
    private String name;
    private int age;
    private String group;

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Student(String n, int a, String g, int h) {
        this(n, a, g);
        height = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student(String name, int age, String group) {
        setName(name);
        setAge(age);
        setGroup(group);
    }

    public void displayInfo() {
        System.out.printf("%-20s%-10d%-5s%n", getName(), getAge(), getGroup());
    }
}
