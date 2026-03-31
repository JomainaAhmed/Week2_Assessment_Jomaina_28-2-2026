package com.lpu.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.demo2.entity.Employee;
import com.lpu.demo2.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Add Employee
    // URL: http://localhost:8080/api/employee
    /*{
    	  "name": "Ravi",
    	  "phone": "9876543210",
    	  "email": "ravi@gmail.com",
    	  "salary": 45000,
    	  "department": "IT"
    	}*/
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.save(employee);
    }

    // Get All Employees
    // URL: http://localhost:8080/api/employee
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    // Get Employee by ID
    // URL: http://localhost:8080/api/employee/id?id=10
    @GetMapping("/id")
    public Employee getEmployeeById(@RequestParam int id) {
        return service.getById(id);
    }

    // Delete Employee by ID
    // URL: http://localhost:8080/api/employee/delete?id=10
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        service.deleteById(id);
        return "Employee deleted successfully";
    }

    // Find by Name
    // URL: http://localhost:8080/api/employee/name?name=Ravi
    @GetMapping("/name")
    public List<Employee> findByName(@RequestParam String name){
        return service.getByName(name);
    }

    // Find by Department
    // URL: http://localhost:8080/api/employee/department?department=Testing
    @GetMapping("/department")
    public List<Employee> findByDepartment(@RequestParam String department){
        return service.getByDepartment(department);
    }

    // Find by Phone
    // URL: http://localhost:8080/api/employee/phone?phone=9876543210
    @GetMapping("/phone")
    public Employee findByPhone(@RequestParam String phone){
        return service.getByPhone(phone);
    }

    // Find by Email
    // URL: http://localhost:8080/api/employee/email?email=ravi@gmail.com
    @GetMapping("/email")
    public Employee findByEmail(@RequestParam String email){
        return service.getByEmail(email);
    }
    
    // Salary Range
    // URL: http://localhost:8080/api/employee/search?minSalary=30000&maxSalary=60000
    @GetMapping("/search")
    public List<Employee> getEmployeesBySalaryRange(
         @RequestParam double minSalary,
         @RequestParam double maxSalary) {

    	return service.getEmployeesBySalaryRange(minSalary, maxSalary);
    }
    
    // URL: http://localhost:8080/api/employee/search/Testing/50000
    @GetMapping("/search/{department}/{minSalary}")
    public List<Employee> getEmployeesByDepartmentAndSalary(
            @PathVariable String department,
            @PathVariable double minSalary) {

        return service.getByDepartmentAndSalaryGreaterThan(department, minSalary);
    }
    
    // Update Employee (Query Param)
    // URL: http://localhost:8080/api/employee?id=10 + JSON body
    @PutMapping
    public Employee updateEmployee(@RequestParam int id,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }
    
    // Max Salary
    // URL: http://localhost:8080/api/employee/max-salary
    @GetMapping("/max-salary")
    public Employee getMaxSalary() {
        return service.getEmployeeWithMaxSalary();
    }

    // Min Salary
    // URL: http://localhost:8080/api/employee/min-salary
    @GetMapping("/min-salary")
    public Employee getMinSalary() {
        return service.getEmployeeWithMinSalary();
    }
}