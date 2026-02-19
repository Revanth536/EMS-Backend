package com.example.First;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeReqDTO dto);
    List<EmployeeResponseDTO> getAllEmployees();
}
