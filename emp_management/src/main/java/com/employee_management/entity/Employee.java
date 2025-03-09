package com.employee_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String name;
    private String department;
    private Double Salary;
    public Employee(Long id, String name, String department, Double salary) {
        Id = id;
        this.name = name;
        this.department = department;
        Salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [Id=" + Id + ", name=" + name + ", department=" + department + ", Salary=" + Salary + "]";
    }
   


}
