package org.rentoutfits.service;

import org.rentoutfits.dto.request.EmployeeDTO;
import org.rentoutfits.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface IEmployee {
    ResponseEntity<?>  save(EmployeeDTO employee);
}
