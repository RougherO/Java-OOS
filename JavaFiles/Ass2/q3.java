package Ass2;

class SequenceGenerator {
    SequenceGenerator(int limit) {
        this.limit = limit;
    }

    synchronized void factorial() {
        while (n < limit) {
            if (!ready) {
                fact = 1;
                for (int i = 1; i <= n; i++) {
                    fact *= i;
                }
                ready = true;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Factorial Interrupted");
                }
            }
            notify();
        }
    }

    synchronized void addSum() {
        while (n < limit) {
            if (ready) {
                result += 1 / fact;
                n++;
                ready = false;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Sum Interrupted");
                }
            }
            notify();
        }
    }

    double getResult() {
        return result;
    }

    private boolean ready = false;
    private double fact = 1;
    private double result = 1;
    private int limit;
    private int n = 1;
}

class Producer extends Thread {
    SequenceGenerator generator;

    Producer(SequenceGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        generator.factorial();
    }
}

class Consumer extends Thread {
    SequenceGenerator generator;

    Consumer(SequenceGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        generator.addSum();
    }
}

public class q3 {
    public static void main(String[] args) {
        int limit = 20;
        SequenceGenerator obj = new SequenceGenerator(limit);

        Producer t1 = new Producer(obj);
        Consumer t2 = new Consumer(obj);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Join");
        }
        System.out.println("Sum of sequence: " + obj.getResult());
    }
}
