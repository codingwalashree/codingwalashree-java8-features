package org.cws.streams.domain.services;

import org.cws.streams.domain.model.EmpDeptDto;
import org.cws.streams.domain.model.Employee;
import org.cws.streams.domain.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author CodingWalaShree
 * Service layer for Employee entity.
 * Return minimal information required to outside world.
 * */
public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    /**
     * Get highest paid employee
     * */
    public Optional<Employee> getHighestPaidEmployee() {
        // TODO: To be implemented
        return Optional.empty();
    }

    /**
     * Get lowest paid employee
     * */
    public Optional<Employee> getLowestPaidEmployee() {
        // TODO: To be implemented
        return Optional.empty();
    }

    /**
     * Get list of employees whose name contains given @param text
     * Stream Methods: filter, collect
     * */
    public List<Employee> getEmployeesByNameContains(String text) {
        return employeeRepository.findByNameContains(text);
    }

    /**
     * Get list of employees living in given @param city
     * Stream Methods: filter, collect
     * */
    public List<Employee> getByCity(String city) {
        return employeeRepository.findByCity(city);
    }

    /**
     * Get employees having given skill
     * Stream Methods: filter, map, collect
     * */
    public List<EmpDeptDto> getEmployeesHavingSkill(String skill) {
        return employeeRepository.findBySkill(skill)
                .stream()
                //.map(e -> new EmpDeptDto(e))
                .map(EmpDeptDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Get list of employee DTOs in given department
     * having salary greater than given @param minSalary
     * Stream Methods: filter, map, collect
     * */
    public List<EmpDeptDto> getHighlyPaidEmployees(long deptId, double minSalary) {
        return employeeRepository.findByDepartmentIdAndSalaryGreaterThan(deptId, minSalary)
                .stream()
                .map(EmpDeptDto::new)
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithExperienceLessThan(double experience) {
        return employeeRepository.findByExperienceLessThan(experience);
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
     * Get skills capacity for given department
     * Stream Methods: filter, flatMap
     * */
    public List<String> getSkillsByDeptId(long deptId) {
        return employeeRepository.findSkillsByDeptId(deptId)
                .stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Sort all employees in by their employee IDs in descending fashion.
     * Stream Methods: sorted, collect
     * */
    public List<Employee> sortById() {
        return employeeRepository.sortById();
    }

    /**
     * Sort all employees by experience in years in ascending fashion.
     * Stream Methods: sorted(Comparator), collect
     * */
    public List<Employee> sortByExperience() {
        return employeeRepository.sortByExperience();
    }

    public List<Employee> sortByExperienceDescending() {
        return employeeRepository.sortByExperienceDescending();
    }

    /**
     * Sort all employees by skill count and experience
     * Stream Methods: sorted(Comparator), collect
     * */
    public List<Employee> sortByExperienceAndSkillCount() {
        return employeeRepository.sortByExperienceAndSkillCount();
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
    public List<Employee> getTop3HighestPaidEmployees() {
        return employeeRepository.findTop3BySalary();
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
    public List<Employee> getAllExceptTop3HighestPaidEmployees() {
        return employeeRepository.skipTop3BySalary();
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
    public List<Employee> getNextTop3Employees() {
        return employeeRepository.findNextTop3Employees();
    }
}
