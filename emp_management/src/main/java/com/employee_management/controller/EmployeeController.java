package com.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.entity.Employee;
import com.employee_management.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService empServices;

    // create employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return empServices.addEmployee(emp);
    }

    // get employee data
    @GetMapping
    public List<Employee> getAllEmployee() {
        return empServices.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return empServices.getEmployeeById(id);
    }

    // updating employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        return empServices.updateEmployee(id, emp);
    }

    // delete employee data
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return empServices.deleteEmployee(id);
    }
}
