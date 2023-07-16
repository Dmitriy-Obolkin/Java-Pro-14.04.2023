package homeworks.hw22.db;

import homeworks.hw22.db.dao.LessonMySqlJdbcDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class SqlUtil {
    public static String readSqlFromFile(String filename){
        InputStream inputStream = LessonMySqlJdbcDao.class.getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new RuntimeException(filename + " file not found.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(filename + " file reading error: " + e.getMessage());
        }
    }
}
