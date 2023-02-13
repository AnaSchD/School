package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository <Student, Long> {

    Collection<Student> findByNameIgnoreCaseAndAge (String name, long age);

    Collection<Student> findStudentsByAgeIsBetween (long min, long max);

}
