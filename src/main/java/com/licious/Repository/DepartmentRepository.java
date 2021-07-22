package com.licious.Repository;

import com.licious.Entity.Department;
import org.springframework.data.repository.CrudRepository;



public interface DepartmentRepository extends CrudRepository<Department, Integer> {}
