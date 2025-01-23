package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Employee> employees = Arrays.asList(
                new Employee("roney", 28, "TCS", "E01", 55000),
                new Employee("ankit", 35, "XYZ", "E02", 48000),
                new Employee("rishav", 22, "Tech Solutions", "E03", 30000),
                new Employee("sarthak", 26, "ABC", "E04", 75000),
                new Employee("sanjay", 40, "Inno ", "E05", 95000)
        );

        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .filter(e -> e.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println("Employess with Salary greater than 50000 & age less than 30: ");
        filteredEmployees.forEach(System.out::println);

        Map<String, Employee> lowSalaryEmployeeMap = employees.stream()
                .filter(e -> e.getSalary() < 40000)
                .collect(Collectors.toMap(Employee::getName, e -> e));
        System.out.println("Employess with Salary less than 40000");

        lowSalaryEmployeeMap.forEach((name, employee) -> System.out.println(name + ": " + employee));

        Map<String, Employee> adultEmployeeMap = employees.stream()
                .filter(e -> e.getAge() > 25)
                .collect(Collectors.toMap(Employee::getName, e -> e));
        System.out.println("Employess with age greater than 25");
        adultEmployeeMap.forEach((name, employee) -> System.out.println(name + ": " + employee));


    }
}
