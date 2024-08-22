package org.example.eksamenii.controllers;

import org.example.eksamenii.models.Champion;
import org.example.eksamenii.services.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/champions")
public class ChampionController {

    private final ChampionService championService;

    @Autowired
    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping
    public List<Champion> getAllChampions() {
        return championService.getAllChampions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Champion> getChampionById(@PathVariable int id) {
        Optional<Champion> champion = championService.getChampionById(id);
        return champion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Champion createChampion(@RequestBody Champion champion) {
        return championService.createChampion(champion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Champion> updateChampion(@PathVariable int id, @RequestBody Champion championDetails) {
        Champion updatedChampion = championService.updateChampion(id, championDetails);
        if (updatedChampion != null) {
            return ResponseEntity.ok(updatedChampion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChampion(@PathVariable int id) {
        championService.deleteChampion(id);
        return ResponseEntity.noContent().build();
    }
}
