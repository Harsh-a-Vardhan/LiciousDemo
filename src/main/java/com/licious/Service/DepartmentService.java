package com.licious.Service;

import java.util.ArrayList;
import java.util.List;

import com.licious.Entity.Department;
import com.licious.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository deptRepository;

    public List<Department> getAllDepartments() {
        List<Department> departmentLists = new ArrayList<Department>();
        deptRepository.findAll().forEach(dept1 -> departmentLists.add(dept1));
        return departmentLists;
    }

    public Department getDepartmentById(int deptId) {
        return deptRepository.findById(deptId).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Department department) throws Exception {
        int contact = department.getContact();
        if (String.valueOf(contact).length() != 10) {
            throw new Exception("Contact should be a 10 digit number");
        }
        int floor = department.getFloor();
        if (floor < 0 || floor > 9) {
            throw new Exception("The floor value should be in between 0 to 9");
        }
        deptRepository.save(department);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int deptId) {
        deptRepository.deleteById(deptId);
    }

    //updating a record
    public void update(Department department) throws Exception {
        int contact = department.getContact();
        if (String.valueOf(contact).length() != 10) {
            throw new Exception("Contact should be a 10 digit number");
        }
        int floor = department.getFloor();
        if (floor < 0 || floor > 9) {
            throw new Exception("The floor value should be in between 0 to 9");
        }
        deptRepository.save(department);
    }

}
