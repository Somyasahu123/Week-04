package map_interface.group_objects_by_property;

import java.util.*;

// Employee class to represent an employee with name and department
class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Override toString() to print employee name
    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        // Example list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        // Call method to group employees by department and print result
        System.out.println(groupByDepartment(employees));
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        // Iterate through employees and group them by department
        for (Employee emp : employees) {
            // If department key does not exist, create a new list
            departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        return departmentMap;
    }
}

