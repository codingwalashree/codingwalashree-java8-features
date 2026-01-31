package org.cws.streams.domain.repositories;

import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CodingWalaShree
 * Dummy Repository layer for managing Departments
 * */
public class DepartmentRepository {
    /**
     * Group the employees department-wise.
     * Stream Methods: collect
     * */
    public Map<Department, List<Employee>> employeesByDepartment() {
        return DatabaseProxy.getEmployees()
                .stream()
                .collect(
                        HashMap::new,
                        (map, emp) -> {
                            // accumulator - add employee to the map
                            Department key = emp.getDepartment();
                            // if department already present in the map - get the list and add our employee
                            // if department does not exist, add a new list with current employee
                            List<Employee> employees = map.getOrDefault(key, new ArrayList<>());
                            employees.add(emp);
                            map.put(key, employees);
                        },
                        (map1, map2) -> {
                            // combiner - merge two maps
                            map2.forEach((key, value) -> {
                                map1.merge(key, value, (v1, v2) -> {
                                    v1.addAll(v2);
                                    return v1;
                                });
                            });
                        }
                );
    }

    /**
     * Group the employees department-wise using grouping by collector.
     * Stream Methods: collect [using Collectors.groupingBy]
     * */
    public Map<Department, List<Employee>> employeesByDepartmentUsingGroupingBy() {
        return DatabaseProxy.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    /**
     * Group the employee IDs department-wise using grouping by collector.
     * Stream Methods: collect [using Collectors.groupingBy and Collectors.mapping]
     * */
    public Map<Department, Set<Long>> findEmployeeIdsByDepartment() {
        return DatabaseProxy.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.mapping(Employee::getId, Collectors.toSet())));
    }

    /**
     * Calculate department-wise average salary using grouping by collector.
     * Stream Methods: collect [using Collectors.groupingBy, Collectors.mapping and Collectors.averagingDouble]
     * */
    public Map<Department, Double> findAverageSalaryByDepartment() {
        return DatabaseProxy.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)));
    }
}
