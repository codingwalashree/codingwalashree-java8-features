package org.cws.streams.domain.repositories;

import org.cws.streams.domain.model.Department;
import org.cws.streams.domain.model.Employee;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

/**
 * @author CodingWalaShree
 * Dummy Repository layer for managing Departments
 * */
public class DepartmentRepository {
    /**
     * --- distinct() and peek() method demo ---
     * Get distinct departments for employees having experience less than given experience.
     * Stream Methods: filter, distinct, peek, collect
     * */
    public List<Employee> findByExperienceLessThan(double exp) {
        // TODO: Yet to be implemented
        return null;
    }

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
}
