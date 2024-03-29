package homeworks.hw13;

/*1. Створити клас FileData. Клас представляє конкретний файл і складається з:
ім'я файлу, розміру в байтах, шлях до файлу.*/
public class FileData {
    private final String name;
    private final long size;
    private final String path;

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
