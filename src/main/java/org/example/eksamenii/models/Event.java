package org.example.eksamenii.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Duration minimumDuration;
    private Integer maximumParticipants;
    private String participantGender;
    private String participantAgeGroup;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")

    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "track_id")

    private Track track;

    @ManyToOne
    @JoinColumn(name = "discipline_id")

    private Discipline discipline;
}

