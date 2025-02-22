package org.cws.streams.domain.services;

import org.cws.streams.domain.model.Department;

import java.util.stream.Stream;

/**
 * @author CodingWalaShree
 * Service layer for handling Departments data
 * */
public class DepartmentService {
    /**
     * --- distinct() and peek() method demo ---
     * Get distinct departments for employees having experience less than given experience.
     * Stream Methods: filter, distinct, peek, collect
     * */
    public Stream<Department> findByExperienceLessThan(double exp) {
        // TODO: Yet to be implemented
        return null;
    }
}
