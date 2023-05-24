package src.main.homeworks.hw12.part2.phonebook;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Entry("Tom", "956754"));
        phoneBook.add(new Entry("Alice", "123456"));
        phoneBook.add(new Entry("Leo", "875678"));
        phoneBook.add(new Entry("Alice", "346154"));
        phoneBook.add(new Entry("Bob", "789456"));

        Entry foundEntry1 = phoneBook.find("Alice");
        System.out.println(foundEntry1);

        Entry foundEntry2 = phoneBook.find("Leo");
        System.out.println(foundEntry2);

        List<Entry> foundEntries = phoneBook.findAll("Alice");
        for (Entry entry : foundEntries) {
            System.out.println(entry);
        }
    }
}
