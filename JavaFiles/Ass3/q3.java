package Ass3;

import java.util.HashSet;
import java.util.Set;

public class q3 {
    static <T> void genericDup(T[] array) {
        Set<T> foundElements = new HashSet<>();

        System.out.print("Duplicates: ");
        for (T element : array) {
            if (!foundElements.add(element)) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 1, 2, 5, 6, 3 };
        System.out.println("[Integer Array]");
        genericDup(intArray);

        String[] stringArray = { "apple", "banana", "orange", "apple", "grape", "banana" };
        System.out.println("[String Array]");
        genericDup(stringArray);
    }
}
