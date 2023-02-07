package ru.hogwarts.school.model;

import javax.persistence.*;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {
   @Id
   @GeneratedValue
    private long id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn (name = "faculty_id")
    private Faculty faculty;

    public Student() {

    }

    public Student (long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

