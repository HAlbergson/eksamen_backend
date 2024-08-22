package org.example.eksamenii.services;

import org.example.eksamenii.models.TimeSlot;
import org.example.eksamenii.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    public TimeSlot getTimeSlotById(int id) {
        return timeSlotRepository.findById(id).orElse(null);
    }

    public TimeSlot createTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    public TimeSlot updateTimeSlot(int id, TimeSlot timeSlotDetails) {
        TimeSlot timeSlot = getTimeSlotById(id);
        if (timeSlot != null) {
            timeSlot.setDate(timeSlotDetails.getDate());
            timeSlot.setStartTime(timeSlotDetails.getStartTime());
            timeSlot.setEndTime(timeSlotDetails.getEndTime());
            // Update other fields as necessary
            return timeSlotRepository.save(timeSlot);
        }
        return null;
    }

    public void deleteTimeSlot(int id) {
        timeSlotRepository.deleteById(id);
    }
}
