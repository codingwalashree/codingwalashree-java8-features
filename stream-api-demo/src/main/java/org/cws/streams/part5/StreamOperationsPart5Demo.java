package org.cws.streams.part5;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 5 -- distinct, peek, limit, skip
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart5Demo {

    public static void main(String[] args) {

    }

    /** peek() - Debugging Stream Pipelines
     * distinct() - Removing duplicates -- distinct() uses equals() and hashCode()
     * Ex 1. Get distinct numbers
     * Ex 2. Get distinct departments for employees having experience less than given experience (DepartmentService)
     */
    public static void distinctPeekDemo() {
        System.out.println("distinct() and peek() demo..");
    }

    /**
     * limit() - Fetching a fixed number of records
     * Ex 1. Limit results from stream of strings
     * Ex 2. Get top 3 highest paid employees
     * */
    public static void limitDemo() {
        System.out.println("limit() demo..");
    }

    /**
     * skip() - Removes the first n elements from the stream
     * Ex 1. Limit results from stream of strings
     * Ex 2. Skip top 3 highest paid employees and get the remaining employees
     * */
    public static void skipDemo() {
        System.out.println("skip() demo..");
    }

    /**
     * Scenario: The company has already shortlisted the top 3 highest-paid employees.
     * Now, we need to fetch the next 2 highest-paid employees for further evaluation.
     * Note: limit() and skip() methods are useful in implementing pagination.
     * */
    public static void skipLimitDemo() {
        System.out.println("skip() and limit() demo..");
    }
}
