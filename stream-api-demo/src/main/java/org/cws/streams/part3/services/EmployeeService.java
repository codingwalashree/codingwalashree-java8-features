package org.cws.streams.part3.services;

import org.cws.streams.part3.model.Department;
import org.cws.streams.part3.repositories.EmployeeRepository;

import java.util.Map;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    public EmployeeService() { }

    public double getAverageSalary() {
        // TODO: Implement the method
        return 0.0;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public Map<Department, Double> calculateDepartmentWiseTotalSalary() {
        return employeeRepository.getDepartmentWiseTotalSalary();
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
