package ru.hogwarts.school.model;

import java.util.Objects;

public class Student {

    private final String NAME;
    private long id;
    private int age;

    public Student(String name, long id, int age) {
        this.NAME = name;
        this.id = id;
        this.age = age;
    }

    public String getNAME() {
        return NAME;
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
        return id == student.id && age == student.age && Objects.equals(NAME, student.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, id, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + NAME + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

