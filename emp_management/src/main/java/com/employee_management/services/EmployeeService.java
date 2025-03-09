package com.employee_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.entity.Employee;
import com.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    // create employees
    public Employee addEmployee(Employee emp) {

        return empRepository.save(emp);
    }

    // get all employee
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    // get employee by id
    public Optional<Employee> getEmployeeById(Long id) {
        return empRepository.findById(id);
    }

    // update employee
    public Employee updateEmployee(Long id, Employee emp){
          return empRepository.findById(id).map((el)->{
            el.setName(emp.getName());
            el.setDepartment(emp.getDepartment());
            el.setSalary(emp.getSalary());
            return empRepository.save(el);
         }).orElseThrow(()-> new RuntimeException("Employee not found"));
    }

    // delete employee
    public String deleteEmployee(Long id) {
        empRepository.deleteById(id);
        return "Deleted";
    }
}
