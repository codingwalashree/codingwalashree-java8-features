package org.cws.streams.part3;

import org.cws.streams.part3.services.EmployeeService;

public class StreamOperationsDemo {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        employeeService.calculateDepartmentWiseTotalSalary();
    }
}
