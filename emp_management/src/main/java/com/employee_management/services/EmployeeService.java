package com.employee_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.entity.Employee;
import com.employee_management.exception.ResourceNotFoundException;
import com.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    // create employees
    public Employee addEmployee(Employee emp) {
        try {
            if (emp.getName() == null || emp.getDepartment() == null) {
                throw new IllegalArgumentException("Name and Department are required fields.");
            }
            return empRepository.save(emp);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }

    }

    // get all employee
    public List<Employee> getAllEmployees() {
        try {
            return empRepository.findAll();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in getting data");
            return null;
        }
    }

    // get employee by id
    public Optional<Employee> getEmployeeById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("Employee Id is required");
            }
            return empRepository.findById(id);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    // update employee
    public Employee updateEmployee(Long id, Employee emp) {
        return empRepository.findById(id).map((el) -> {
            el.setName(emp.getName());
            el.setDepartment(emp.getDepartment());
            el.setSalary(emp.getSalary());
            return empRepository.save(el);
        }).orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "not found"));
    }

    // delete employee
    public String deleteEmployee(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("Employee Id is required");
            }
            empRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }

    }
}
