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
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        return facultyRepository.save(faculty);
//        if (!faculties.containsKey(id)) {
//            return null;
//        }
//        faculties.put(faculty.getId(), faculty);
//        return faculty;
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }


    public Collection<Faculty> getOnColor(String color) {
//        ArrayList<Faculty> colorFac = new ArrayList<>();
//        for (Faculty faculty : faculties.values()) {
//            if (faculty.getColor().equals(color)) {
//                colorFac.add(faculty);
//            }
//        }
//        return colorFac;
        return facultyRepository.findByColor(color);
    }
}
