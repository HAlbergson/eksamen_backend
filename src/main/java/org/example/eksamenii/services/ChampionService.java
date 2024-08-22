package org.example.eksamenii.services;

import org.example.eksamenii.models.Champion;
import org.example.eksamenii.repositories.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionService {

    private final ChampionRepository championRepository;

    @Autowired
    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    // Create a new Champion
    public Champion createChampion(Champion champion) {
        return championRepository.save(champion);
    }

    // Get all Champions
    public List<Champion> getAllChampions() {
        return championRepository.findAll();
    }

    // Get a single Champion by ID
    public Optional<Champion> getChampionById(int id) {
        return championRepository.findById(id);
    }

    // Update an existing Champion
    public Champion updateChampion(int id, Champion championDetails) {
        Optional<Champion> optionalChampion = championRepository.findById(id);

        if (optionalChampion.isPresent()) {
            Champion champion = optionalChampion.get();
            champion.setName(championDetails.getName());
            champion.setRegion(championDetails.getRegion());
            champion.setRole(championDetails.getRole());
            return championRepository.save(champion);
        } else {
            // Handle the case where the champion is not found, e.g., throw an exception
            return null;
        }
    }

    // Delete a Champion by ID
    public void deleteChampion(int id) {
        championRepository.deleteById(id);
    }
}
