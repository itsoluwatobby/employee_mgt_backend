package com.itsOluwatobby.SpringApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EmployeeId;
    private String EmployeeName;
    private String role;
    

    public Employee() {}

    public Employee(String EmployeeName, String role) {
        this.EmployeeName = EmployeeName;
        this.role = role;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(EmployeeId, employee.EmployeeId)
                && Objects.equals(EmployeeName, employee.EmployeeName)
                && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.EmployeeId, this.EmployeeName, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + EmployeeId +
                ", name='" + EmployeeName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
