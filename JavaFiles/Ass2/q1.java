package Ass2;

public class q1 {
    static Thread my_thread = new Thread() {
        @Override
        public void run() {
            System.out.println("In child thread");
        }
    };

    public static void main(String[] args) {
        System.out.println("In main thread");
        my_thread.run();
    }
}
