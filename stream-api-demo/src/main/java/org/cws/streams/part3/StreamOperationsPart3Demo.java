package org.cws.streams.part3;

import org.cws.streams.domain.model.Address;
import org.cws.streams.domain.services.EmployeeService;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 3 -- filter, map, flatMap
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart3Demo {
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        filterMapFlatMapDemo();
    }

    public static void filterMapFlatMapDemo() {
        System.out.println("Getting employees containing 'ee' in their name");
        employeeService.getEmployeesByNameContains("ee")
                .stream()
                .forEach(System.out::println);

        System.out.println("------------------------------");
        System.out.println("Getting employees living in 'Mumbai'");
        employeeService.getByCity(Address.CT_MUMBAI)
                .forEach(System.out::println);

        System.out.println("------------------------------");
        System.out.println("Getting employees having skill 'React'");
        employeeService.getEmployeesHavingSkill("React")
                .forEach(System.out::println);

        System.out.println("------------------------------");
        System.out.println("Getting employees in HR department (deptId = 2) and salary greater than 100K");
        employeeService.getHighlyPaidEmployees(2, 85000)
                .forEach(System.out::println);
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Getting all skills in a HR department");
        employeeService.getSkillsByDeptId(2)
                .forEach(System.out::println);
    }
}
