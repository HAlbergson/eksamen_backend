package org.example.eksamenii.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Discipline {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;
   private Duration approxDuration;

   @OneToMany(mappedBy = "discipline")
    private List<Event> events;
}
