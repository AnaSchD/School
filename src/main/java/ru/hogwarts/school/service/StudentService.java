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
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
//        if (!students.containsKey(id)) {
//            return null;
//        }
//        students.put(student.getId(), student);
//        return student;
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
//        return students.remove(id);
    }

//    public Collection<Student> getOnAge(long age) {
//        ArrayList<Student> ageStud = new ArrayList<>();
//        for (Student student: students.values()) {
//            if (student.getAge() == age) {
//                ageStud.add(student);
//            }
//        }
//        return ageStud;
//    }

    public Collection<Student> getOnAge(long age) {
        return studentRepository.findByAge(age);
    }

}
