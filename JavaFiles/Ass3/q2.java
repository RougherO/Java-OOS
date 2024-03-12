package Ass3;

import java.util.HashMap;
import java.util.Map;

public class q2 {
    static <T> Map<T, Integer> genericFreq(T[] array) {
        Map<T, Integer> frequencyMap = new HashMap<>();

        for (T element : array) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5, 1, 2, 3, 1, 2 };
        Map<Integer, Integer> intFrequencyMap = genericFreq(intArray);

        System.out.println("Frequency of elements in Integer Array:");

        for (Map.Entry<Integer, Integer> entry : intFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String[] stringArray = { "apple", "banana", "apple", "orange", "banana" };
        Map<String, Integer> stringFrequencyMap = genericFreq(stringArray);

        System.out.println("\nFrequency of elements in String Array:");

        for (Map.Entry<String, Integer> entry : stringFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
