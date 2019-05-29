package org.bulld.workers_shifts_schedule.controller;


import org.bulld.workers_shifts_schedule.exception.ResourceNotFoundException;
import org.bulld.workers_shifts_schedule.model.Shift;
import org.bulld.workers_shifts_schedule.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ShiftController {
    @Autowired
    private ShiftRepository shiftRepository;

    @GetMapping("/shifts")
    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    @GetMapping("/shifts/{date}")
    public List<Shift> getShiftsByDate(@PathVariable(value = "date") String shiftDate){return shiftRepository.findAllByDate(LocalDate.parse(shiftDate));}

    @PostMapping("/shifts")
    public Shift createShift(@Valid @RequestBody Shift shift) {
        return shiftRepository.save(shift);
    }

    @PutMapping("/shifts/{id}")
    public ResponseEntity<Shift> updateShift(@PathVariable(value = "id") Long shiftId,
                                                   @Valid @RequestBody Shift shiftDetails) throws ResourceNotFoundException {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found for this id :: " + shiftId));

        shift.setEmployee(shiftDetails.getEmployee());
        shift.setDate(shiftDetails.getDate());
        final Shift updatedShift = shiftRepository.save(shift);
        return ResponseEntity.ok(updatedShift);
    }

    @DeleteMapping("/shifts/{id}")
    public Map<String, Boolean> deleteShift(@PathVariable(value = "id") Long shiftId)
            throws ResourceNotFoundException {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found for this id :: " + shiftId));

        shiftRepository.delete(shift);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
