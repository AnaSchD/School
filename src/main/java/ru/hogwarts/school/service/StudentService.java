package ru.hogwarts.school.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) // конструктор
    {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) // метод добавления студентов
    {
        logger.info ("Был вызван метод для создания студента: {} ", student);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) //метод получения студентов по id
    {
        logger.info ("Был вызван метод для получения студента по id: {} ", id);
        return studentRepository.findById(id).get();
    }

    public Student editStudent(long id, Student student) //метод редактирования студентов
    {
        logger.debug ("Был вызван метод для редактирования студента: {} ", student);
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        } return null;
    }

    public void deleteStudent(long id) // метод удаления студентов
    {
        logger.debug ("Был вызван метод для удаления студента по id: {} ", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() //метод получения всех студентов
    {
        logger.info ("Был вызван метод получения всех студентов без параметров");
        return studentRepository.findAll();
    }

    public Collection<Student> getOnAge(int age) //метод получения студентов по возрасту
    {
        logger.info ("Был вызван метод получения студентов по возрасту: {} ", age);
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getByAgeBetween(int min, int max) //метод получения студентов по заданным параметрам мин/макс
    {
        logger.info ("Был вызван метод получения студентов по возрасту from {} to {}", min, max);
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFacultyByStudent(long studentId) //метод получения факультета по студенту
    {
        logger.info ("Был вызван метод получения факультета по студенту: {} ", studentId);
        return studentRepository.findById(studentId).map(Student::getFaculty).orElse(null);
    }

    public double getAverageAge() {
        logger.info ("Был вызван метод среднего возраста всех студентов");
        return studentRepository.getAverageAge();
    }

    public Integer getAllStud() {
        logger.info ("Был вызван метод получения числа всех студентов");
        return studentRepository.getAllStudents();
    }

    public Collection<Student> getLastStudents() {
        logger.info ("Был вызван метод получения последних пяти студентов");
        return studentRepository.getLastStudent();
    }





}
