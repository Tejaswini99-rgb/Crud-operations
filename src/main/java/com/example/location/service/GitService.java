package com.example.location.service;

import java.util.List;

import com.example.location.dto.GitDto;



public interface GitService {
	GitDto createEmployee(GitDto employeeDto);
    
    GitDto getEmployeeById(int id);
    
    List<GitDto> getAllEmployees();
    
    GitDto updateEmployee(int id, GitDto gitDTO);
    
    void deleteEmployee(int id);
}
