package org.example.eksamenii.services;

import org.example.eksamenii.models.Discipline;
import org.example.eksamenii.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    public Discipline getDisciplineById(int id) {
        return disciplineRepository.findById(id).orElse(null);
    }

    public Discipline createDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public Discipline updateDiscipline(int id, Discipline disciplineDetails) {
        Discipline discipline = getDisciplineById(id);
        if (discipline != null) {
            discipline.setName(disciplineDetails.getName());
            discipline.setApproxDuration(disciplineDetails.getApproxDuration());
            return disciplineRepository.save(discipline);
        }
        return null;
    }

    public void deleteDiscipline(int id) {
        disciplineRepository.deleteById(id);
    }
}
