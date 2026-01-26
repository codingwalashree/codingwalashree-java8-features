package org.cws.streams.domain.services;

import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;
import org.cws.streams.domain.repositories.DepartmentRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CodingWalaShree
 * Service layer for handling Departments data
 * */
public class DepartmentService {
    private final EmployeeService employeeService = new EmployeeService();
    private final DepartmentRepository departmentRepository = new DepartmentRepository();

    /**
     * --- distinct() and peek() method demo ---
     * Get distinct departments for employees having experience less than given experience.
     * Stream Methods: filter, distinct, peek, collect
     * */
    public List<Department> getDepartmentsHavingExperienceLessThan(double exp) {
        return employeeService.getEmployeesWithExperienceLessThan(exp)
                .stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toList());
    }

    public Map<Department, List<Employee>> getEmployeesByDepartment() {
        return departmentRepository.employeesByDepartment();
    }
}
