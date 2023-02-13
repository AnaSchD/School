package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) //конструктор
    {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) //метод добавления факультета
    {
//        Faculty faculty1 = facultyRepository.save(faculty);
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) //метод получения факультета по id
    {
        return facultyRepository.findById(id).get();
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty editFaculty(long id, Faculty faculty) //метод редактирования факультета
    {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) //метод удаления факультета
    {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getOnColor(String color) //метод получения факультета по цвету
    {
        return facultyRepository.findByColorContainsIgnoreCase(color);
    }

    public Collection<Faculty> getByColor(String color) //метод получения факультета по цвету
    {
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public Collection<Faculty> getByName(String name) //метод получения факультета по названию
    {
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Collection<Student> getStudentsByFaculty(long facultyId) {
        return findFaculty(facultyId).getStudents();
    }


}
