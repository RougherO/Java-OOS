import java.util.Arrays;

public class q3 {
    public static void main(String[] args) {
        Stack stack = new Stack(30);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(15);
        stack.push(9);

        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();

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
