package org.cws.streams.part6;

/**
 * @author CodingWalaShree
 * Application or Client for EmployeeService and DepartmentService -- Part 6
 * Terminal Operations covered -- forEach, forEachOrdered, count, min, max, toArray
 * Logical flow / project structure:
 * Application Layer --> Service Layer --> Repository Layer --> Database / DatabaseProxy
 */
public class StreamOperationsPart6Demo {

    public static void main(String[] args) {

    }

    /** forEach() -- Run Consumer for every element in the Stream
     * forEachOrdered() - Run Consumer for every element in the Stream
     * encounter order
     * Ex 1. Print numbers in the stream using forEach and forEachOrdered (use with parallel stream)
     * Ex 2. Print sorted employees using forEach and forEachOrdered
     */
    public static void forEachDemo() {
        System.out.println("forEach() demo..");

        System.out.println("forEachOrdered() demo..");

    }

    /** count() -- Returns number of elements in Stream
     * Ex 1. count elements in the stream of Doubles
     * Ex 2. Get count of employees after filtering the Stream
     */
    public static void countDemo() {
        System.out.println("count() demo..");

    }

    /** min(Comparator) -- Returns the minimum element of this stream according to the provided Comparator.
     * Ex 1. Minimum number from the stream of Doubles
     * Ex 2. Get the lowest paid employee
     */
    public static void minDemo() {
        System.out.println("min() demo..");

    }

    /** max(Comparator) -- Returns the maximum element of this stream according to the provided Comparator.
     * Ex 1. Maximum number from the stream of Doubles
     * Ex 2. Get the highest paid employee
     */
    public static void maxDemo() {
        System.out.println("max() demo..");

    }

    /** toArray() -- Returns an array containing the elements of this stream
     * toArray(IntFunction) -- Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array,
     * Ex 1. Get array of doubles from the stream of Doubles -- toArray()
     * Ex 2. Get array of employee IDs from employees -- toArray(IntFunction)
     */
    public static void toArrayDemo() {
        System.out.println("toArray() demo..");

    }
}
