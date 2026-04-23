package task2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UtilClass {

    private static Scanner sc = new Scanner(System.in);

    public static Item getItem(List<Item> items, String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new NoSuchElementException("Предмет " + name + " не найден");
    }

    public static String inputMessage() {
        return sc.nextLine();
    }

    public static void printListItems(List<Item> items) {
        for (Item item : items) {
            int count = 1;
            System.out.println(count + "." + item.getName());
        }
    }
}
