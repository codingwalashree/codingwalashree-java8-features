package org.cws.streams.domain.model;

import java.util.List;

/**
 * @author CodingWalaShree
 * EmpDept DTO with minimal required fields
 * */
public class EmpDeptDto {
    private long empId;
    private String empName;
    private String deptName;
    private List<String> skills;
    private double salary;
    private String city;

    public EmpDeptDto(long empId, String empName, String deptName, List<String> skills, double salary, String city) {
        this.empId = empId;
        this.empName = empName;
        this.deptName = deptName;
        this.skills = skills;
        this.salary = salary;
        this.city = city;
    }

    public EmpDeptDto(Employee employee) {
        this.empId = employee.getId();
        this.empName = employee.getName();
        this.deptName = employee.getDepartment().getName();
        this.skills = employee.getSkills();
        this.salary = employee.getSalary();
        this.city = employee.getAddress().getCity();
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EmpDeptDto{");
        sb.append("empId=").append(empId);
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", deptName='").append(deptName).append('\'');
        sb.append(", skills=").append(skills);
        sb.append(", salary=").append(salary);
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
