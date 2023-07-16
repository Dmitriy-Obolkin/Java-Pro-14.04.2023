package homeworks.hw22.db.dao;

import homeworks.hw22.db.SqlUtil;
import homeworks.hw22.db.model.Homework;
import homeworks.hw22.db.model.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonMySqlJdbcDao implements LessonDao{
    private static final String ADD_LESSON_MySQL = SqlUtil.readSqlFromFile("sql/hw22/addLesson.sql");
    private static final String REMOVE_LESSON_MySQL = SqlUtil.readSqlFromFile("sql/hw22/removeLesson.sql");
    private static final String FIND_ALL_LESSONS_MySQL = SqlUtil.readSqlFromFile("sql/hw22/findAllLessons.sql");
    private static final String FIND_LESSON_BY_ID_MySQL = SqlUtil.readSqlFromFile("sql/hw22/findLessonById.sql");
    private final Connection connection;


    public LessonMySqlJdbcDao(Connection connection){
        this.connection = connection;
    }


    @Override
    public void addLesson(Lesson lesson) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_LESSON_MySQL, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setTimestamp(2, lesson.getUpdatedAt());
            preparedStatement.setInt(3, lesson.getHomework().getId());

            int affRows = preparedStatement.executeUpdate();
            if(affRows == 0){
                System.out.println("Failed to add lesson to the database.");
            } else {
                System.out.println("Lesson successfully added to the database.");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if(generatedKeys.next()){
                    lesson.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error adding lesson to database. " + e.getMessage());
        }
    }

    @Override
    public void removeLesson(Lesson lesson) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_LESSON_MySQL)){
            int lessonId = lesson.getId();
            preparedStatement.setInt(1, lessonId);

            int affRows = preparedStatement.executeUpdate();
            if(affRows == 0){
                System.out.println("Failed to remove lesson from the database.");
            } else {
                System.out.println("Lesson successfully removed from the database.");
            }

        } catch (SQLException e) {
            System.out.println("Error removing lesson from database. " + e.getMessage());
        }
    }

    @Override
    public List<Lesson> findAllLessons(){
        List<Lesson> lessons = new ArrayList<>();

        try(Statement statement = connection.createStatement()){
            if(statement.execute(FIND_ALL_LESSONS_MySQL)){
                ResultSet resultSet = statement.getResultSet();

                boolean hasRows = resultSet.next();
                if (hasRows) {
                    do {
                        Homework homework = new Homework();
                        homework.setId(resultSet.getInt("homework_id"));
                        homework.setName(resultSet.getString("homework_name"));
                        homework.setDescription(resultSet.getString("homework_description"));

                        Lesson lesson = new Lesson();
                        lesson.setId(resultSet.getInt("lesson_id"));
                        lesson.setName(resultSet.getString("lesson_name"));
                        lesson.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
                        lesson.setHomework(homework);

                        lessons.add(lesson);
                    } while(resultSet.next());
                } else {
                    System.out.println("No results found for the SQL getAllLessons query");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error selecting all lessons. " + e.getMessage());
        }

        return lessons;
    }

    @Override
    public Lesson findLessonById(int lessonId){
        Lesson lesson = null;
        try(PreparedStatement statement = connection.prepareStatement(FIND_LESSON_BY_ID_MySQL)){
            statement.setInt(1, lessonId);

            if(statement.execute()){
                ResultSet resultSet = statement.getResultSet();

                if(resultSet.next()){

                    Homework homework = new Homework();
                    homework.setId(resultSet.getInt("homework_id"));
                    homework.setName(resultSet.getString("homework_name"));
                    homework.setDescription(resultSet.getString("homework_description"));

                    lesson = new Lesson();
                    lesson.setId(resultSet.getInt("lesson_id"));
                    lesson.setName(resultSet.getString("lesson_name"));
                    lesson.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
                    lesson.setHomework(homework);

                } else{
                    System.out.printf("No lesson found with id = %d.%n", lessonId);
                }
            }
        } catch (SQLException e) {
            System.out.printf("Error selecting lesson by id = %d. %s%n", lessonId, e.getMessage());
        }
        return lesson;
    }

}
