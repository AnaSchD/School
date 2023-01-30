package ru.hogwarts.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private long id;
    private final String NAME;
    private String color;

    public Faculty(long ID, String NAME, String COLOR) {
        this.id = ID;
        this.NAME = NAME;
        this.color = COLOR;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(NAME, faculty.NAME) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, NAME, color);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "ID=" + id +
                ", NAME='" + NAME + '\'' +
                ", COLOR='" + color + '\'' +
                '}';
    }
}
