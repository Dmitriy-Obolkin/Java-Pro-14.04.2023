package homeworks.hw22.db.dao;

import homeworks.hw22.db.model.Homework;
import homeworks.hw22.db.model.Lesson;

public interface HomeworkDao {
    Homework findHomeworkById(int homeworkId);
}
