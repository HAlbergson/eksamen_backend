package org.example.eksamenii.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Track {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String type;
   private String shape;
   private String surface;
   private String length;
   private String lanes;

   @OneToMany(mappedBy = "track")
   @JsonIgnore
   private List<Event> events;
}
