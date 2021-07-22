package com.licious.Controller;

import java.util.List;

import com.licious.Entity.Employee;
import com.licious.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    //creating a get mapping that retrieves all the employees' details from the database
    @GetMapping("/employee")
    private List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

    //creating a get mapping that retrieves the detail of a specific employee
    @GetMapping("/employee/{employeeid}")
    private Employee getEmployee(@PathVariable("employeeid") int empId) {
        return empService.getEmployeeById(empId);
    }

    //creating a delete mapping that deletes a specified employee
    @DeleteMapping("/employee/delete/{employeeid}")
    private void deleteEmployee(@PathVariable("employeeid") int empId) {
        empService.delete(empId);
    }

    //creating post mapping that post the employee detail in the database
    @PostMapping("/employee/add")
    private int saveEmployee(@RequestBody Employee employee) throws Exception {
        empService.saveOrUpdate(employee);
        return employee.getEmpId();
    }

    //creating put mapping that updates the employee detail
    @PutMapping("/employee/edit")
    private Employee update(@RequestBody Employee employee) throws Exception {
        empService.update(employee);
        return employee;
    }

}