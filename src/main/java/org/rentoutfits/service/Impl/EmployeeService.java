package org.rentoutfits.service.Impl;


import org.rentoutfits.dto.request.EmployeeDTO;
import org.rentoutfits.entity.Employee;
import org.rentoutfits.repository.EmployeeRepository;
import org.rentoutfits.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployee {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<?> save(EmployeeDTO employee) {
        Employee employeeEntity = new Employee();
        employeeEntity.setName(employee.getName());
        employeeEntity.setRole(employee.getRole());
        employeeEntity.setPhone(employee.getPhone());
        employeeEntity.setAddress(employee.getAddress());

        return ResponseEntity.ok().body(employeeRepository.save(employeeEntity));
    }
}
