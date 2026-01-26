package org.cws.streams.part8;

import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;
import org.cws.streams.domain.services.DepartmentService;
import org.cws.streams.domain.services.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectDemo {
    private static final DepartmentService departmentService = new DepartmentService();

    public static void main(String[] args) {
        // simpleCollectDemo();
        getDepartmentWiseEmployees();
    }

    /**
     * Pick only unique even numbers
     * */
    public static void simpleCollectDemo() {
        List<Integer> numbers =
                Arrays.asList(1, 2, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 10, 10);
        Set<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
//                .collect(HashSet::new,
//                        HashSet::add,
//                        HashSet::addAll);
                .collect(Collectors.toSet());
        System.out.println("Even numbers = " + evenNumbers);
    }

    /**
     * Real-project structure
     * Get list of employees grouped by department
     * */
    public static void getDepartmentWiseEmployees() {
        Map<Department, List<Employee>> deptEmps = departmentService.getEmployeesByDepartment();
        deptEmps.forEach((dept, employees) -> {
            System.out.println("\n\nEmployees in department " + dept.getName() + ":");
            EmployeeService.printEmployees(employees);
        });
    }
}
