package org.cws.streams.part3.repositories;

import org.cws.streams.part3.model.Department;
import org.cws.streams.part3.model.Employee;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

/**
 * @author CodingWalaShree
 * Dummy Repository layer for managing Departments
 * */
public class DepartmentRepository {
    /**
     * Given a department ID, returns total salary required to be paid to all employees in the given department.
     * Stream Methods: filter, mapToDouble, reduce, sum
     * */
    public double calculateTotalSalaryForDepartment(long deptId) {
        // TODO: Yet to be implemented
        return 0.0;
    }

    /**
     * Group the employees department-wise.
     * Stream Methods: filter, reduce
     * */
    public Map<Department, List<Employee>> aggregateByDepartment() {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Department wise average, min, max, sum of salary
     * */
    public Map<Department, DoubleSummaryStatistics> getDepartmentWiseSummaryStatistics() {
        // TODO: Yet to be implemented
        return null;
    }

    /**
     * Department wise sum of salary for all departments
     * */
    public Map<Department, Double> getDepartmentWiseTotalSalary() {
        // TODO: Yet to be implemented
        return null;
    }

//    /**
//     * Utility method to create identity or dummy employee
//     * */
//    public static Employee employeeIdentity() {
//        return new Employee(0, "", Address.inMumbai(""), Collections.singletonList(""), new Department(0, ""), 0, 0);
//    }
}
