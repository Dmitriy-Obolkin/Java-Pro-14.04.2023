package homeworks.hw22.db.dao;

import homeworks.hw22.db.SqlUtil;
import homeworks.hw22.db.model.Homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeworkMySqlJdbcDao implements HomeworkDao{
    private static final String FIND_HOMEWORK_BY_ID_MySQL = SqlUtil.readSqlFromFile("sql/hw22/findHomeworkById.sql");
    private final Connection connection;

    public HomeworkMySqlJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Homework findHomeworkById(int homeworkId) {
        Homework homework = null;
        try(PreparedStatement statement = connection.prepareStatement(FIND_HOMEWORK_BY_ID_MySQL)){
            statement.setInt(1, homeworkId);

            if(statement.execute()){
                ResultSet resultSet = statement.getResultSet();

                if(resultSet.next()){

                    homework = new Homework();
                    homework.setId(resultSet.getInt("homework_id"));
                    homework.setName(resultSet.getString("homework_name"));
                    homework.setDescription(resultSet.getString("homework_description"));
                } else{
                    System.out.printf("No homework found with id = %d.%n", homeworkId);
                }
            }
        } catch (SQLException e) {
            System.out.printf("Error selecting homework by id = %d. %s%n", homeworkId, e.getMessage());
        }
        return homework;
    }
}
