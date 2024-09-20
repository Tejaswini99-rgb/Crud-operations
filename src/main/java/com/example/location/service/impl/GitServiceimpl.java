package com.example.location.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.exception.EmployeeNotFoundException;
import com.example.location.dto.GitDto;
import com.example.location.model.Git;
import com.example.location.repo.Gitrepo;
import com.example.location.service.GitService;
@Service
public class GitServiceimpl implements GitService{

	@Autowired
	  private Gitrepo gitRepository;

	    @Autowired
	    private ModelMapper modelMapper;
	    // create new employee
	    
	    @Override
	    public GitDto createEmployee(GitDto gitDto) {
	        Git git = modelMapper.map(gitDto, Git.class);
	        Git savedEmployee = gitRepository.save(git);
	        return modelMapper.map(savedEmployee, GitDto.class);
	    }
	    
	   //get employee by id
	    @Override
	    public GitDto getEmployeeById(int id) {
	        Git git = gitRepository.findById(id)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
	        return modelMapper.map(git, GitDto.class);
	    }

	    // get all employees
	    @Override
	    public List<GitDto> getAllEmployees() {
	        return gitRepository.findAll()
	                .stream()
	                .map(employee -> modelMapper.map(employee, GitDto.class))
	                .collect(Collectors.toList());
	    }

	    //update the employee
	    
	    @Override
	    public GitDto updateEmployee(int id, GitDto employeeDTO) {
	        Git employee = gitRepository.findById(id)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with" +id));

	        employee.setName(employeeDTO.getName());
	        

	        Git updatedEmployee = gitRepository.save(employee);
	        return modelMapper.map(updatedEmployee, GitDto.class);
	    }
       
	    //delete the employee
	    @Override
	    public void deleteEmployee(int id) {
	        Git employee = gitRepository.findById(id)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id "+id));
	        gitRepository.delete(employee);
	    }
}
