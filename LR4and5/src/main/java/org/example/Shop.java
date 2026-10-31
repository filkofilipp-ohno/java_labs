package org.example;

class Shop {
    public String name;
    public double area;
    public int employees;

    public Shop(String n, double a, int e) {
        name = n;
        area = a;
        employees = e;
    }
    public String toString(){
        return name + " " + area + " " + employees;
    }
}