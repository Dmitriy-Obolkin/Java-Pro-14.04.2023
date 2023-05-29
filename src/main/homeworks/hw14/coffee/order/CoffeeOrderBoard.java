package src.main.homeworks.hw14.coffee.order;

import java.util.HashMap;
import java.util.LinkedList;

public class CoffeeOrderBoard {
    private LinkedList<Order> queue = new LinkedList<>();

    /*Если заказов много и/или часто нужно искать заказ по номеру, то HashMap обеспечит более быстрый поиск O(1), по сравнению с LinkedList O(n).
    * Иначе, можно обойтись только LinkedList, что сэкономит часть памяти*/
    private HashMap<Integer, Order> map = new HashMap<>();
    private int currentOrderNumber = 1;

    /*3. Реалізувати метод add у класі CoffeeOrderBoard. Даний метод додає нове замовлення та надає замовленню номер (натуральний порядок).
    Натуральний порядок (natural ordering) означає, що й у останнього замовлення номер 86, то наступний буде 87.
    Не може бути такої ситуації, що номер повторюється у межах одного об'єкта типу CoffeeOrderBoard.*/
    public void add(String customerName) {
        Order order = new Order(currentOrderNumber++, customerName);
        queue.add(order);
        map.put(order.getOrderNumber(), order);
        System.out.println("Order successfully added! " + order);
    }

    /*4. Реалізувати метод deliver у класі CoffeeOrderBoard. Цей метод видає найближче у черзі замовлення.
    Видача супроводжується видаленням замовлення зі списку.*/
    public Order deliver() {
        if (queue.isEmpty()) {
            return null;
        }
        Order order = queue.removeFirst();
        map.remove(order.getOrderNumber());
        System.out.println("Order " + order.getOrderNumber() + " delivered successfully");
        return order;
    }

    /*5. Реалізувати метод deliver у класі CoffeeOrderBoard. Даний метод видає замовлення з певним номером.
    Видача супроводжується видаленням замовлення зі списку.
    Даний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, готове раніше.*/
    public Order deliver(int orderNumber) {
        Order order = map.get(orderNumber);
        if (order != null) {
            queue.remove(order);
            map.remove(order.getOrderNumber());
            System.out.println("Order " + order.getOrderNumber() + " delivered successfully");
            return order;
        } else {
            System.out.println("Order " + orderNumber + " not found");
            return null;
        }

    }

    /*6. Реалізувати метод draw у класі CoffeeOrderBoard. Цей метод виводить у консоль інформацію
    про поточний стан черги у порядку найближчого до видачі замовлення.*/
    public void draw() {
        System.out.println("==============");
        System.out.println(String.format("%-3s | %-10s", "Num", "Name"));

        for (Order order : queue) {
            System.out.println(String.format("%-3s | %-10s", order.getOrderNumber(), order.getCustomerName()));
        }
    }

}
