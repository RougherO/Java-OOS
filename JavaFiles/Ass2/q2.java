package Ass2;

class SequenceGenerator {
    private int limit;
    private int counter = 1;

    SequenceGenerator(int n) {
        limit = n;
    }

    synchronized void printSyncOdd() {
        while (counter <= limit) {
            if (counter % 2 == 1) {
                System.out.print(counter + " ");
                counter++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.print("Interrupt in Sync Odd");
                }
            }
        }
    }

    synchronized void printSyncEven() {
        while (counter <= limit) {
            if (counter % 2 == 0) {
                System.out.print(counter + " ");
                counter++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.print("Interrupt in Sync Even");
                }
            }
        }
    }
}

class OddThread extends Thread {
    SequenceGenerator generator;

    OddThread(SequenceGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        generator.printSyncOdd();
    }
}

class EvenThread extends Thread {
    SequenceGenerator generator;

    EvenThread(SequenceGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        generator.printSyncEven();
    }
}

public class q2 {
    public static void main(String[] args) {
        int limit = 100;
        SequenceGenerator gen = new SequenceGenerator(limit);

        OddThread t1 = new OddThread(gen);
        EvenThread t2 = new EvenThread(gen);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Threads interrupted");
        }
    }
}
