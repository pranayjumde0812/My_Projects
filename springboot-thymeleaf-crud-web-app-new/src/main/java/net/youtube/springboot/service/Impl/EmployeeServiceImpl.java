package net.youtube.springboot.service.Impl;

import net.youtube.springboot.model.Employee;
import net.youtube.springboot.repository.EmployeeRepository;
import net.youtube.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;

        if(optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException(" Employee Not Found for ID :: "+id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
            this.employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortFeild, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortFeild).ascending() :
                Sort.by(sortFeild).descending();

        Pageable pageableSorting = PageRequest.of(pageNo - 1 , pageSize , sort);

        return this.employeeRepository.findAll(pageableSorting);
    }
}
