package org.cws.streams.domain.services;

import org.cws.streams.domain.model.Department;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CodingWalaShree
 * Service layer for handling Departments data
 * */
public class DepartmentService {
    private EmployeeService employeeService = new EmployeeService();

    /**
     * --- distinct() and peek() method demo ---
     * Get distinct departments for employees having experience less than given experience.
     * Stream Methods: filter, distinct, peek, collect
     * */
    public List<Department> getDepartmentsHavingExperienceLessThan(double exp) {
        return employeeService.getEmployeesWithExperienceLessThan(exp)
                .stream()
                .map(e -> e.getDepartment())
                .collect(Collectors.toList());
    }
}
