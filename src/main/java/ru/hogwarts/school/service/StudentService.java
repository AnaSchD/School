package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) // конструктор
    {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) // метод добавления студентов
    {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) //метод получения студентов по id
    {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(long id, Student student) //метод редактирования студентов
    {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        } return null;
    }

    public void deleteStudent(long id) // метод удаления студентов
    {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() //метод получения всех студентов
    {
        return studentRepository.findAll();
    }

    public Collection<Student> getOnAge(long age) //метод получения студентов по возрасту
    {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getByAgeBetween(long min, long max) //метод получения студентов по заданным параметрам мин/макс
    {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFacultyStudent(long studentId) {
        return studentRepository.findById(studentId).get().getFaculty();
    }

}
