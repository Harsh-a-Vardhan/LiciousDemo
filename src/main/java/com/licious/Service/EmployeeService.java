package com.licious.Service;

import java.util.ArrayList;
import java.util.List;

import com.licious.Entity.Employee;
import com.licious.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employeeLists = new ArrayList<Employee>();
        empRepository.findAll().forEach(emp1 -> employeeLists.add(emp1));
        return employeeLists;
    }

    public Employee getEmployeeById(int empId) {
        return empRepository.findById(empId).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Employee employee) throws Exception {
        int contact = employee.getContact();
        if (String.valueOf(contact).length() != 10) {
            throw new Exception("Contact should be a 10 digit number");
        }
        empRepository.save(employee);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int empId) {
        empRepository.deleteById(empId);
    }

    //updating a record
    public void update(Employee employee) throws Exception {
        int contact = employee.getContact();
        if (String.valueOf(contact).length() != 10) {
            throw new Exception("Contact should be a 10 digit number");
        }
        empRepository.save(employee);
    }

}
