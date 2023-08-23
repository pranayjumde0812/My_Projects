package com.dailycodebuffer.crudoperations.repository;

import com.dailycodebuffer.crudoperations.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    @Query(value = "")
    Department findByDepartmentName(Department department);

}
