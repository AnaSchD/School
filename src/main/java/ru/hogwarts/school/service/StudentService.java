package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        Student student1 = studentRepository.save(student);
        return studentRepository.save(student1);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(long id, Student student) {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        } return null;
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> getOnAge(long age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getByAgeBetween(long min, long max) {
        return studentRepository.findByAgeBetween(min, max);
    }


    

}
