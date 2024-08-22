package org.example.eksamenii.controllers;

import org.example.eksamenii.models.TimeSlot;
import org.example.eksamenii.services.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @GetMapping
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotService.getAllTimeSlots();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlot> getTimeSlotById(@PathVariable int id) {
        TimeSlot timeSlot = timeSlotService.getTimeSlotById(id);
        if (timeSlot != null) {
            return ResponseEntity.ok(timeSlot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TimeSlot createTimeSlot(@RequestBody TimeSlot timeSlot) {
        return timeSlotService.createTimeSlot(timeSlot);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSlot> updateTimeSlot(@PathVariable int id, @RequestBody TimeSlot timeSlotDetails) {
        TimeSlot updatedTimeSlot = timeSlotService.updateTimeSlot(id, timeSlotDetails);
        if (updatedTimeSlot != null) {
            return ResponseEntity.ok(updatedTimeSlot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeSlot(@PathVariable int id) {
        timeSlotService.deleteTimeSlot(id);
        return ResponseEntity.noContent().build();
    }
}
