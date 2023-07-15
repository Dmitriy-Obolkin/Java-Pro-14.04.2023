package homeworks.hw12.part2.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    List<Entry> entries;

    public PhoneBook(){
        this.entries = new ArrayList<>();
    }

    /*5. У класі Телефонний Довідник реалізувати метод add. Метод додає Запис до Телефонного Довідника.
    Примітка: Під одним прізвищем може зберігатися кілька телефонів, тому можлива наявність декількох записів.*/
    public void add(Entry entry){
        entries.add(entry);
    }

    /*6. У класі Телефонний Довідник реалізувати метод find(). Метод здійснює пошук конкретного запису на ім'я.
    Якщо запис знайдений (перший знайдений), тоді його необхідно повернути, інакше повертається null.*/
    public Entry find(String name){
        for (Entry entry : entries){
            if(entry.name.equals(name)){
                return entry;
            }
        }

        return null;
    }

    /*8. * У класі Телефонний Довідник реалізувати метод findAll(). Метод здійснює пошук записів на ім'я.
    Якщо записи знайдені, тоді їх необхідно повернути, інакше повертається null.
    Така реалізація викликана тим, що під одним прізвищем може зберігатися кілька телефонів
    і при запиті по конкретному імені необхідно повертати всі записи, що є в наявності.*/
    public List<Entry> findAll(String name){
        List<Entry> foundEntries = new ArrayList<>();

        for (Entry entry : entries){
            if(entry.getName().equalsIgnoreCase(name)){
                foundEntries.add(entry);
            }
        }

        return foundEntries.isEmpty() ? null : foundEntries;
    }
}
