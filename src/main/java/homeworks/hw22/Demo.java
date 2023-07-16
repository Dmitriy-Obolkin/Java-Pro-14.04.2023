package homeworks.hw22;

import homeworks.hw22.db.connection.DataBaseConnection;
import homeworks.hw22.db.dao.HomeworkMySqlJdbcDao;
import homeworks.hw22.db.dao.LessonMySqlJdbcDao;
import homeworks.hw22.db.model.Homework;
import homeworks.hw22.db.model.Lesson;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String host = System.getenv("JDBC_HOST");
        String dbName = System.getenv("JDBC_DB_NAME");
        String user = System.getenv("JDBC_USER");
        String pass = System.getenv("JDBC_PASSWORD");
        String url = String.format("%s/%s", host, dbName);

        DataBaseConnection dataBaseConnection = new DataBaseConnection(url, user, pass);

        try(Connection conn = dataBaseConnection.getConnection()){
            LessonMySqlJdbcDao lessonDao = new LessonMySqlJdbcDao(conn);
            HomeworkMySqlJdbcDao homeworkDao = new HomeworkMySqlJdbcDao(conn);


            Homework homework = homeworkDao.findHomeworkById(4);
            // TODO: if(homework == null){ request to create and add a new homework to db }

            Lesson lesson5 = new Lesson();
            lesson5.setName("Lesson5");
            lesson5.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            lesson5.setHomework(homework);

            lessonDao.addLesson(lesson5);


            lessonDao.removeLesson(lesson5);


            List<Lesson> allLessons = lessonDao.findAllLessons();
            System.out.println("All lessons:" + allLessons);

            System.out.println();

            Lesson lesson1 = lessonDao.findLessonById(1);
            Lesson lesson441 = lessonDao.findLessonById(441);
            System.out.println("Lesson by Id = 1: " + lesson1);
            System.out.println("Lesson by Id = 441: " + lesson441);


        } catch (SQLException e){
            System.out.println("Unable to create connection.%n" + e.getMessage());
        }
    }
}
