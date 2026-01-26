package org.cws.streams.part8;

import org.cws.streams.domain.services.EmployeeService;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 8
 * Terminal Operations covered -- Overloads of reduce and collect
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart8Demo {
    private final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        collectDemo();
        reduceDemo();
    }

    /**
     * Overloads of collect() operation
     * */
    public static void collectDemo() {

    }

    /**
     * Overloads of reduce() operation
     * */
    public static void reduceDemo() {

    }
}
