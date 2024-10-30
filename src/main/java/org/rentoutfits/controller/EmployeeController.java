package org.rentoutfits.controller;

import org.rentoutfits.dto.request.EmployeeDTO;
import org.rentoutfits.entity.Employee;
import org.rentoutfits.service.Impl.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }
}
