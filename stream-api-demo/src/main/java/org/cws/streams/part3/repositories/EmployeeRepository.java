package org.cws.streams.part3.repositories;

import org.cws.streams.part3.model.Employee;
import java.util.List;

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
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Get list of employees living in given @param city
     * Stream Methods: filter, collect
     * */
    public List<Employee> findByCity(String city) {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Get list of employees in given department
     * having salary greater than given @param minSalary
     * Stream Methods: filter, collect
     * */
    public List<Employee> findByDepartmentIdAndSalaryGreaterThan(long deptId, double minSalary) {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Get list of skills of an employee with given employee id
     * Stream Methods: filter, map, collect
     * */
    public List<String> findSkillsByEmpId(long empId) {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Get list of employees having a given @param skill
     * Stream Methods: filter, collect
     * */
    public List<Employee> findBySkill(String skill) {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Calculate average salary for all employees in given department
     * Stream Methods: filter, mapToDouble, average
     * */
    public double calculateAverageSalary(long deptId) {
        // TODO: Yet to be implemented
        return 0.0;
    }

    /**
     * Get list of skills in a given department
     * Stream Methods: filter, flatMap, collect
     * Example:
     * Input: deptId = 2 (HR)
     * Output: "Recruitment", "Screening", "Onboarding", "People Management"
     * */
    public List<String> findSkillsByDeptId(long deptId) {
        // TODO: Yet to be implemented
        return null;
    }

}
