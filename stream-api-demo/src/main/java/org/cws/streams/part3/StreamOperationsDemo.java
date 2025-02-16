package org.cws.streams.part3;

import org.cws.streams.part3.model.Address;
import org.cws.streams.part3.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 * */
public class StreamOperationsDemo {
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        // filterMapFlatMapDemo();
        // basicSortingDemo();
        customSortingDemo();

    }

    public static void basicSortingDemo() {
        System.out.println("------------ Basic sorting with sorted() ------------------");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        List<String> names = new ArrayList<>();
        names.add("BAC");
        names.add("AAC");
        names.add("4NC");
        names.add("BAC1");
        names.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorting by ID in given city");
        employeeService.getByCity(Address.CT_PUNE)
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorting by ID");
        employeeService.sortById()
                .forEach(System.out::println);
    }

    public static void customSortingDemo() {
        System.out.println("------------ Custom sorting with sorted(Comparator) ------------------");
//        employeeService.sortByExperience()
//                .forEach(System.out::println);

//        employeeService.sortByExperienceDescending()
//                .forEach(System.out::println);

        employeeService.sortByExperienceAndSkillCount()
                .forEach(System.out::println);
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
