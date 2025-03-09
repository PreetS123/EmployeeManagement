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

        if (emp.getName() == null || emp.getDepartment() == null) {
            throw new IllegalArgumentException("Name and Department are required fields.");
        }
        return empRepository.save(emp);

    }

    // get all employee
    public List<Employee> getAllEmployees() {

        return empRepository.findAll();

    }

    // get employee by id
    public Optional<Employee> getEmployeeById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Employee Id is required");
        }
        return Optional.of(empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "not found")));

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
    public void deleteEmployee(Long id) {

        if (!empRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee with id " + id + " not found");
        }
        empRepository.deleteById(id);

    }
}
