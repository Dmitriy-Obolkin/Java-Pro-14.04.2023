package src.main.homeworks.hw7;

public class Main {
    public static void main(String[] args) {

        /*2. Створити метод findSymbolOccurance. Метод приймає як параметр рядок і символ.
        Необхідно обчислити, скільки разів символ зустрічається в переданому рядку
        і повернути це числове значення.*/
        System.out.println(HW7Service.findSymbolOccurance("Hello, world!", 'l'));

        /*3. Створити метод findWordPosition. Метод приймає як параметри два рядки (source, target).
        Необхідно з'ясувати, чи є target (підрядок) частиною рядка source. Якщо так,
        тоді повернути номер позиції (індекс) першого елемента підрядка у рядку, інакше повернути -1.*/
        System.out.println(HW7Service.findWordPosition("Apollo", "pollo"));
        System.out.println(HW7Service.findWordPosition("Apple", "Plant"));

        /*4. Створити метод stringReverse. Метод приймає як параметр - рядок.
        Необхідно її розгорнути та повернути змінений варіант.*/
        System.out.println(HW7Service.stringReverse("Hello, world!"));
        System.out.println(HW7Service.stringReverse2("Hello, world!"));
        System.out.println(HW7Service.stringReverse3("Hello, world!"));

        /*5. Створити метод isPalindrome. Метод приймає як параметр - рядок.
        Необхідно Перевірити, чи є переданий рядок паліндромом.
        Якщо так, тоді повернуть true, інакше false.*/
        System.out.println(HW7Service.isPalindrome("Level"));
        System.out.println(HW7Service.isPalindrome("allo"));

        /*6.*/
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" ,
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        HW7Service.playGame(words);
    }
}
