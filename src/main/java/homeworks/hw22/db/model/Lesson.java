package homeworks.hw22.db.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Lesson {
    private Integer id;
    private String name;
    private Timestamp updatedAt;
    private Homework homework;


    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedAt=" + updatedAt +
                ", homework=" + homework +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
