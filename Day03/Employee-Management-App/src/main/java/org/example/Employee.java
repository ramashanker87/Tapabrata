package org.example;

public class Employee {
    private String name;
    private int age;
    private String company;
    private String id;
    private int salary;

    public Employee(String name, int age, String company, String id, int salary) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.id = id;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    public String getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", company='" + company + "', id='" + id + "', salary=" + salary + "}";
    }
}
