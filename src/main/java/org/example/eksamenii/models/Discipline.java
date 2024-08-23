package org.example.eksamenii.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Discipline {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;
   private Duration approxDuration;

   @OneToMany(mappedBy = "discipline")
   @JsonIgnore
   private List<Event> events;
}
