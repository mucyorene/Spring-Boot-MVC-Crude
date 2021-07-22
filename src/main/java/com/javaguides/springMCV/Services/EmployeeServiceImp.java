package com.javaguides.springMCV.Services;

import com.javaguides.springMCV.model.Employee;
import com.javaguides.springMCV.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

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
        Optional<Employee> optional = this.employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException("Employee Not found please id: "+id);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        this.employeeRepository.deleteById(id);
    }
}
