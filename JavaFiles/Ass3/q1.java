package Ass3;

public class q1 {
    static <T extends Comparable<? super T>> void genericSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = { 5, 3, 8, 2, 1 };
        genericSort(intArray);
        System.out.println("Sorted Integer Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] stringArray = { "banana", "apple", "orange", "grape" };
        genericSort(stringArray);
        System.out.println("Sorted String Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}