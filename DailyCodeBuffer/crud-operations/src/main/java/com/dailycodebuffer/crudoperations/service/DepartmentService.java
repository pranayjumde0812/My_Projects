package com.dailycodebuffer.crudoperations.service;

import com.dailycodebuffer.crudoperations.model.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartment(Department department);

    Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
