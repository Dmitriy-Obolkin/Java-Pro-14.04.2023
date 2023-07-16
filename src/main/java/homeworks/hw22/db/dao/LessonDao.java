package homeworks.hw22.db.dao;

import homeworks.hw22.db.model.Lesson;

import java.sql.Connection;
import java.util.List;

public interface LessonDao {
    void addLesson(Lesson lesson);
    void removeLesson(Lesson lesson);
    List<Lesson> findAllLessons();
    Lesson findLessonById(int lessonId);
}
