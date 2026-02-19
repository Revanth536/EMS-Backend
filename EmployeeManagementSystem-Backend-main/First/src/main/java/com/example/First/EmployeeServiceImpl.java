package com.example.First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmRepo employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeReqDTO dto) {
        if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }

        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setEmail(dto.getEmail());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private EmployeeResponseDTO mapToResponseDTO(Employee employee) {
        EmployeeResponseDTO response = new EmployeeResponseDTO();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setEmail(employee.getEmail());
        response.setCreatedAt(employee.getCreatedAt());
        return response;
    }
}
