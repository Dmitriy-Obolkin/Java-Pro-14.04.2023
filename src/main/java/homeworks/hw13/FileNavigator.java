package homeworks.hw13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap = new HashMap<>();

    /*2. Реалізувати метод add у класі FileNavigator. Цей метод додає файл за вказаним шляхом.
    Якщо шлях вже існує, новий файл необхідно додати до списку, вже пов'язаному з відповідним шляхом.
    ВАЖЛИВО: Шлях – унікальне значення і не повинно повторюватися.
    */
    /*7. ** Реалізувати перевірку консистентності у методі add у класі FileNavigator.
    Не дозволяти додавати значення і повідомити про це в консолі, при спробі додати значення FileData
    значення шляху якого не відповідає шляху-ключу, що веде до списку файлів.
    Наприклад:
    Має бути помилка, оскільки шлях-ключ і шлях до файлу не співпадають
    Шлях: /path/to/file
    FileData: {name: ..., size: ..., path: /another/path/}*/
    public void add(String path) {
        Path filePath = Paths.get(path).toAbsolutePath();
        File file = filePath.toFile();

        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
        }
        if (!file.isFile()) {
            System.out.println("Path does not represent a file: " + filePath);
            return;
        }
        try {
            BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
            long fileSize = attr.size();
            String fileName = file.getName();
            String directoryPath = filePath.getParent().toString();
            FileData fileData = new FileData(fileName, fileSize, filePath.toString());
            fileMap.computeIfAbsent(directoryPath, k -> new ArrayList<>()).add(fileData);
            System.out.println("Successfully added file " + fileName + " - Size: " + fileSize + " bytes.");
        } catch (IOException e) {
            System.out.println("Failed to read file attributes: " + filePath);
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileMap=" + fileMap +
                '}';
    }

    /*3. Реалізувати метод find у класі FileNavigator. Метод повертає список файлів,
        пов'язаних з шляхом переданим як параметр.*/
    public List<FileData> find(String path) {
        Path absPath = Paths.get(path).toAbsolutePath();

        if(absPath.toFile().isDirectory()){
            return fileMap.get(absPath.toString());
        } else {
            throw new IllegalArgumentException("The passed path is not a directory or does not exist");
        }
    }


    /*4. Реалізувати метод filterBySize у класі FileNavigator. Метод повертає список файлів,
    розмір (в байтах) яких не перевищує значення, передане як параметр.*/
    public List<FileData> filterBySize(long size) {
        List<FileData> files = new ArrayList<>();

        for (List<FileData> fileList : fileMap.values()) {
            for (FileData fileData : fileList) {
                if (fileData.getSize() <= size) {
                    files.add(fileData);
                }
            }
        }

        return files;
    }

    /*5. Реалізувати метод remove у класі FileNavigator. Метод видаляє шлях і пов'язані з ним файли,
    виходячи з значення шляху, переданого як параметр.*/
    public void remove(String path) {
        Path absPath = Paths.get(path).toAbsolutePath();

        if(absPath.toFile().isDirectory()){
            fileMap.remove(absPath.toString());
        } else {
            throw new IllegalArgumentException("The passed path is not a directory or does not exist");
        }
    }


    /*6. * Реалізувати метод sortBySize у класі FileNavigator. Метод сортує всі наявні файли за розміром (за зростанням),
    потім повертає список відсортованих файлів.*/
    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();

        for (List<FileData> fileList : fileMap.values()) {
            allFiles.addAll(fileList);
        }

        allFiles.sort(Comparator.comparingLong(FileData::getSize));

        return allFiles;
    }


}
