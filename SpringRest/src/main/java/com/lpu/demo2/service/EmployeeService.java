package com.lpu.demo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo2.entity.Employee;
import com.lpu.demo2.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Employee> getByName(String name) {
        return repository.findByName(name);
    }

    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public Employee getByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public Employee getByEmail(String email) {
        return repository.findByEmail(email);
    }
    
    // Update Employee (Simple Version)
    public Employee updateEmployee(int id, Employee employee) {

        employee.setId(id);   // set ID from query param
        return repository.save(employee);

    }
    
    // Salary between range
    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
        return repository.findBySalaryBetween(minSalary, maxSalary);
    }

    // Department + Salary greater than
    public List<Employee> getByDepartmentAndSalaryGreaterThan(String department, double salary) {
        return repository.findByDepartmentAndSalaryGreaterThan(department, salary);
    }

    // Highest salary
    public Employee getEmployeeWithMaxSalary() {
        return repository.findTopByOrderBySalaryDesc();
    }

    // Lowest salary
    public Employee getEmployeeWithMinSalary() {
        return repository.findTopByOrderBySalaryAsc();
    }


}