package org.bulld.workers_shifts_schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeePositionController {
    @Autowired
    EmployeePositionRepository employeePositionRepository;

    @GetMapping("/employee_positions")
    public List<EmployeePosition> getAllEmployeePositions() {return employeePositionRepository.findAll();}

    @GetMapping("/employee_positions/{id}")
    public ResponseEntity<EmployeePosition> getEmployeePositionById(@PathVariable(value = "id") Long employeePositionId)
            throws ResourceNotFoundException {
        EmployeePosition employeePosition = employeePositionRepository.findById(employeePositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee position not found for this id :: " + employeePositionId));
        return ResponseEntity.ok().body(employeePosition);
    }

    @PostMapping("/employee_positions")
    public EmployeePosition createEmployeePosition(@Valid @RequestBody EmployeePosition employeePosition) {
        return employeePositionRepository.save(employeePosition);
    }

    @PutMapping("/employee_positions/{id}")
    public ResponseEntity<EmployeePosition> updateEmployeePosition(@PathVariable(value = "id") Long employeePositionId,
                                                   @Valid @RequestBody EmployeePosition employeePositionDetails) throws ResourceNotFoundException {
        EmployeePosition employeePosition = employeePositionRepository.findById(employeePositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee position not found for this id :: " + employeePositionId));

        employeePosition.setName(employeePositionDetails.getName());
        final EmployeePosition updatedEmployeePosition = employeePositionRepository.save(employeePosition);
        return ResponseEntity.ok(updatedEmployeePosition);
    }

    @DeleteMapping("/employee_positions/{id}")
    public Map<String, Boolean> deleteEmployeePosition(@PathVariable(value = "id") Long employeePositionId)
            throws ResourceNotFoundException {
        EmployeePosition employeePosition = employeePositionRepository.findById(employeePositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee position not found for this id :: " + employeePositionId));

        employeePositionRepository.delete(employeePosition);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
