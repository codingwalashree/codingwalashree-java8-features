package org.cws.streams.part3.model;

/**
 * @author CodingWalaShree
 * Department entity
 * */
public class Department {
    /**
     * Member variables of Department class
     * */
    private long id;
    private String name;

    /**
     * Parameterized All Arguments Constructor
     * */
    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getters only.
     * I am not providing Setters here; as department is once created can't be modified.
     * */
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Department{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
