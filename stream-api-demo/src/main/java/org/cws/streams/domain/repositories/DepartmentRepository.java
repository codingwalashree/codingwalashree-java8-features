package org.cws.streams.domain.repositories;

import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
