package com.licious.Controller;

import java.util.List;

import com.licious.Entity.Department;
import com.licious.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService deptService;
    //creating a get mapping that retrieves all the departments' details from the database
    @GetMapping("/department")
    private List<Department> getAllDepartments()
    {
        return deptService.getAllDepartments();
    }
    //creating a get mapping that retrieves the detail of a specific department
    @GetMapping("/department/{departmentid}")
    private Department getDepartment(@PathVariable("departmentid") int deptId)
    {
        return deptService.getDepartmentById(deptId);
    }
    //creating a delete mapping that deletes a specified employee
    @DeleteMapping("/department/delete/{departmentid}")
    private void deleteDepartment(@PathVariable("departmentid") int deptId)
    {  deptService.delete(deptId);  }
    //creating post mapping that post the department details in the database
    @PostMapping("/department/add")
    private int saveDepartment( @RequestBody Department department) throws Exception {
        deptService.saveOrUpdate(department);
        return department.getDeptId();
    }
    //creating put mapping that updates the department details
    @PutMapping("/department/edit")
    private Department update( @RequestBody Department department) throws Exception {
        deptService.update(department);
        return department;
    }
}

