package org.cws.streams.part3.services;

import org.cws.streams.part3.model.EmpDeptDto;
import org.cws.streams.part3.model.Employee;
import org.cws.streams.part3.repositories.EmployeeRepository;

import java.util.List;

/**
 * @author CodingWalaShree
 * Service layer for Employee entity.
 * Return minimal information required to outside world.
 * */
public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    /**
     * Get list of employees whose name contains given @param text
     * Stream Methods: filter, collect
     * */
    public List<Employee> getEmployeesByNameContains(String text) {
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
     * Get employees having given skill
     * Stream Methods: filter, map, collect
     * */
    public List<EmpDeptDto> getEmployeesHavingSkill(String skill) {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Get list of employee DTOs in given department
     * having salary greater than given @param minSalary
     * Stream Methods: filter, map, collect
     * */
    public List<EmpDeptDto> getHighlyPaidEmployees(long deptId, double minSalary) {
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

}
