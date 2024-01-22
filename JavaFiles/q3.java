import java.util.Arrays;

public class q3 {
    public static void main(String[] args) {
        // Create a stack to hold a maximum of 30 integers
        Stack stack = new Stack(30);

        // Push the numbers 10, 20, 30, 15, 9 onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(15);
        stack.push(9);

        // Print the stack
        stack.printStack();

        // Pop thrice
        stack.pop();
        stack.pop();
        stack.pop();

        // Print the stack again
        stack.printStack();
    }
}

class Stack {
    private int[] arr;
    private int top;
    private int maxSize;

    public Stack(int size) {
        maxSize = size;
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            arr[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        } else {
            System.out.println("Stack overflow. Cannot push " + value);
        }
    }

    public void pop() {
        if (top >= 0) {
            int poppedValue = arr[top--];
            System.out.println("Popped " + poppedValue + " from the stack");
        } else {
            System.out.println("Stack underflow. Cannot pop from an empty stack");
        }
    }

    public void printStack() {
        System.out.print("Stack elements: ");
        Arrays.stream(arr, 0, top).forEach((value) -> System.out.print(value + ", "));
        System.out.println(arr[top]);
    }
}
