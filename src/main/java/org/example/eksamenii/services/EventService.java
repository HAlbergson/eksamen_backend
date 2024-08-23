package org.example.eksamenii.services;
import org.example.eksamenii.models.Discipline;
import org.example.eksamenii.models.Event;
import org.example.eksamenii.models.TimeSlot;
import org.example.eksamenii.models.Track;
import org.example.eksamenii.repositories.DisciplineRepository;
import org.example.eksamenii.repositories.EventRepository;
import org.example.eksamenii.repositories.TimeSlotRepository;
import org.example.eksamenii.repositories.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);


    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        logger.info("Fetched {} events", events.size());
        return events;
    }

    public Event getEventById(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createEvent(Event event) {
        // Additional logic to check track suitability and other business rules
        return eventRepository.save(event);
    }

    public Event updateEvent(int id, Event eventDetails) {
        Event event = getEventById(id);
        if (event != null) {
            event.setMinimumDuration(eventDetails.getMinimumDuration());
            event.setParticipantGender(eventDetails.getParticipantGender());
            event.setParticipantAgeGroup(eventDetails.getParticipantAgeGroup());
            event.setMaximumParticipants(eventDetails.getMaximumParticipants());

            // Check and update related entities
            if (eventDetails.getTrack() != null) {
                Track track = trackRepository.findById(eventDetails.getTrack().getId()).orElse(null);
                event.setTrack(track);
            }
            if (eventDetails.getDiscipline() != null) {
                Discipline discipline = disciplineRepository.findById(eventDetails.getDiscipline().getId()).orElse(null);
                event.setDiscipline(discipline);
            }
            if (eventDetails.getTimeSlot() != null) {
                TimeSlot timeSlot = timeSlotRepository.findById(eventDetails.getTimeSlot().getId()).orElse(null);
                event.setTimeSlot(timeSlot);
            }

            return eventRepository.save(event);
        }
        return null;
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
