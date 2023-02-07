package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        Faculty faculty1 = facultyRepository.save(faculty);
        return facultyRepository.save(faculty1);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getOnColor(String color) {
        return facultyRepository.findByColorContainsIgnoreCase(color);
    }

    public Collection<Faculty> getByColor( String color) {
        return facultyRepository.findByColorIgnoreCase (color);
    }

    public Collection<Faculty> getByName(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }

}
