package com.example.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.location.dto.GitDto;
import com.example.location.service.GitService;
@RestController
@RequestMapping("/api/employees")
public class GitController {
	

	    @Autowired
	    private GitService employeeService;

	    @PostMapping("/create")
	    public ResponseEntity<GitDto> createEmployee(@RequestBody GitDto employeeDTO) {
	        GitDto createdEmployee = employeeService.createEmployee(employeeDTO);
	        return ResponseEntity.ok(createdEmployee);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<GitDto> getEmployeeById(@PathVariable int id) {
	        GitDto employeeDTO = employeeService.getEmployeeById(id);
	        return ResponseEntity.ok(employeeDTO);
	    }

	    @GetMapping("getall")
	    public ResponseEntity<List<GitDto>> getAllEmployees() {
	        List<GitDto> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<GitDto> updateEmployee(@PathVariable int id, @RequestBody GitDto employeeDTO) {
	        GitDto updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
	        employeeService.deleteEmployee(id);
	        String message = "Employee with ID " + id + " deleted successfully";
	        System.out.println(message);
	        return ResponseEntity.ok(message);
	    }
	   
}
