package com.employee_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {

        Employee savedEmp = empServices.addEmployee(emp);
        return ResponseEntity.ok(savedEmp);

    }   

    // get employee data
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> emp= empServices.getAllEmployees();
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> emp= empServices.getEmployeeById(id);
        return emp.map(ResponseEntity:: ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    // updating employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        Employee empU= empServices.updateEmployee(id, emp);
            return ResponseEntity.ok(empU);

    }

    // delete employee data
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        empServices.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted sucessfully");
    }
}
