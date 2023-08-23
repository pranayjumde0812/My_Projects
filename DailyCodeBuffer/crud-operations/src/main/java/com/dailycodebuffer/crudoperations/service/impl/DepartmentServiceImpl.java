package com.dailycodebuffer.crudoperations.service.impl;

import com.dailycodebuffer.crudoperations.model.Department;
import com.dailycodebuffer.crudoperations.repository.DepartmentRepo;
import com.dailycodebuffer.crudoperations.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> fetchDepartment(Department department) {
        return departmentRepo.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepo.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepo.deleteById(departmentId);
    }


}
