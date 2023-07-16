package homeworks.hw22.db.dao;

import homeworks.hw22.db.model.Homework;

public interface HomeworkDao {
    Homework findHomeworkById(int homeworkId);
}
