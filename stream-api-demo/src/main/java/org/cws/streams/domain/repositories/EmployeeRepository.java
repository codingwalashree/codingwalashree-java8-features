package org.cws.streams.domain.repositories;

import org.cws.streams.domain.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author CodingWalaShree
 * Dummy Repository layer for managing Employees
 * */
public class EmployeeRepository {
    /**
     * Get highest paid employee
     * */
    public Optional<Employee> findByHighestSalary() {
        return DatabaseProxy.getEmployees()
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    /**
     * Get lowest paid employee
     * */
    public Optional<Employee> findByLowestSalary() {
        return DatabaseProxy.getEmployees()
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

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
     * Sort all employees in by their employee IDs in descending fashion.
     * Stream Methods: sorted, collect
     * */
    public List<Employee> sortById() {
        return DatabaseProxy.getEmployees()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Sort all employees by experience in years in ascending fashion.
     * Stream Methods: sorted, collect
     * */
    public List<Employee> sortByExperience() {
        return DatabaseProxy.getEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getExperienceInYears))
                .collect(Collectors.toList());
    }

    /**
     * Sort all employees by experience in years in descending fashion.
     * Stream Methods: sorted, collect
     * */
    public List<Employee> sortByExperienceDescending() {
        return DatabaseProxy.getEmployees()
                .stream()
                .sorted(
                        Comparator.comparingDouble(Employee::getExperienceInYears)
                                .reversed()
                )
                .collect(Collectors.toList());
    }

    /**
     * Sort all employees by skill count and experience
     * Stream Methods: sorted, collect
     * */
    public List<Employee> sortByExperienceAndSkillCount() {
        return DatabaseProxy.getEmployees()
                .stream()
                .sorted(Comparator
                        .comparingDouble(Employee::getExperienceInYears)
                        .thenComparing((Employee e) -> e.getSkills().size())
                        .reversed()
                )
                .collect(Collectors.toList());
    }

    public List<Employee> findByExperienceLessThan(double experience) {
        return DatabaseProxy.getEmployees()
                .stream()
                .filter(e -> e.getExperienceInYears() < experience)
                .collect(Collectors.toList());
    }

    /**
     * --- limit() method demo ---
     * Get top 3 highest paid employees
     * Steps:
     *      Sort the result by salary in descending fashion - sorted
     *      Log employees if sorted as expected - peek
     *      Restrict top 3 employees - limit
     * Stream Methods: peek, filter, sorted, collect
     * */
    public List<Employee> findTop3BySalary() {
        return DatabaseProxy.getEmployees()
            .stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .collect(Collectors.toList());
    }

    /**
     * --- skip() method demo ---
     * Skip top 3 highest paid employees and get the remaining employees
     * Steps:
     *      Sort the result by salary in descending fashion - sorted
     *      Log employees if sorted as expected - peek
     *      Restrict top 3 employees - skip
     * Stream Methods: peek, filter, sorted, skip, collect
     * */
    public List<Employee> skipTop3BySalary() {
        return DatabaseProxy.getEmployees()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(3)
                .collect(Collectors.toList());
    }

    /**
     * --- skip() and limit() method demo ---
     * The company has already shortlisted the top 3 highest-paid employees.
     * Now, we need to fetch the next 2 highest-paid employees for further evaluation.
     *      Sort the result by salary in descending fashion - sorted
     *      Log employees if sorted as expected - peek
     *      Skip top 3 employees - skip
     *      Restrict top 2 employees - limit
     * Stream Methods: peek, filter, sorted, skip, collect
     * */
    public List<Employee> findNextTop3Employees() {
        return DatabaseProxy.getEmployees()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(3)
                .limit(2)
                .collect(Collectors.toList());
    }
}
