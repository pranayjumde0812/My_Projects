package net.youtube.springboot.service;

import net.youtube.springboot.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    Page<Employee> findPaginated(int pageNo , int  pageSize , String sortFeild , String sortDirection);
}
