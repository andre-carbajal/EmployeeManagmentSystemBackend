package net.anvian.employeemanagmentsystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import net.anvian.employeemanagmentsystem.exception.NotFoundExeption;
import net.anvian.employeemanagmentsystem.model.Employee;
import net.anvian.employeemanagmentsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@Tag(name = "Employee", description = "Employee Management")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    @Operation(
            summary = "Get all employees on a List",
            description = "Get all employees from the database",
            tags = {"Employee", "Get"})
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    @Transactional
    @Operation(
            summary = "Add a new employee",
            description = "Add a new employee to the database",
            tags = {"Employee", "Add", "Transaction"})
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    @Operation(
            summary = "Get an employee by id",
            description = "Get an employee from the database by id",
            tags = {"Employee", "Get"})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundExeption("Employee not found with id: " + id));

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    @Transactional
    @Operation(
            summary = "Update an employee by id",
            description = "Update an employee from the database by id",
            tags = {"Employee", "Update", "Transaction"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundExeption("Employee not found with id: " + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    @Transactional
    @Operation(
            summary = "Delete an employee by id",
            description = "Delete an employee from the database by id",
            tags = {"Employee", "Delete", "Transaction"})
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundExeption("Employee not found with id: " + id));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
