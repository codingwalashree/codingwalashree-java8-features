package org.cws.streams.part3.repositories;

import org.cws.streams.part3.model.Employee;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CodingWalaShree
 * Dummy Repository layer for managing Employees
 * */
public class EmployeeRepository {
    /**
     * Get list of employees whose name contains given @param text
     * Stream Methods: filter, collect
     * Example:
     * Input: "a"
     * Output: 5 employees with name containing "a"
     * */
    public List<Employee> findByNameContains(String text) {
        return DatabaseProxy.getEmployees()
                .stream()
                .filter(e -> e.getName().contains(text))
                .collect(Collectors.toList());
    }

    /**
     * Get list of employees living in given @param city
     * Stream Methods: filter, collect
     * */
    public List<Employee> findByCity(String city) {
        return DatabaseProxy.getEmployees()
                .stream()
                .filter(e -> e.getAddress().getCity().equals(city))
                .collect(Collectors.toList());
    }

    /**
     * Get list of employees in given department
     * having salary greater than given @param minSalary
     * Stream Methods: filter, collect
     * */
    public List<Employee> findByDepartmentIdAndSalaryGreaterThan(long deptId, double minSalary) {
        return DatabaseProxy.getEmployees()
                .stream()
                .filter(e -> e.getDepartment().getId() == deptId && e.getSalary() > minSalary)
                .collect(Collectors.toList());
    }

    /**
     * Get list of skills of an employee with given employee id
     * Stream Methods: filter, map, collect
     * */
    public List<Employee> findSkillsByDeptId(long deptId) {
        return DatabaseProxy.getEmployees()
                .stream()
                .filter(e -> e.getDepartment().getId() == deptId)
                .collect(Collectors.toList());
    }

    /**
     * Get list of employees having a given @param skill
     * Stream Methods: filter, collect
     * */
    public List<Employee> findBySkill(String skill) {
        return DatabaseProxy.getEmployees()
                .stream()
                .filter(e -> e.getSkills().contains(skill))
                .collect(Collectors.toList());
    }

    /**
     * Calculate average salary for all employees in given department
     * Stream Methods: filter, mapToDouble, average
     * */
    public double calculateAverageSalary(long deptId) {
        // TODO: Yet to be implemented
        return 0.0;
    }

}
