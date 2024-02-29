package Ass1;

import java.util.Random;
import java.util.stream.IntStream;

public class q15 {
    public static void main(String[] args) {
        TollBooth tollBooth = new TollBooth(50.0);

        IntStream
                .range(0, 10)
                .forEach(
                        (value) -> tollBooth.carPassed((new Random()).nextBoolean()));

        System.out.println(tollBooth);
    }
}

class TollBooth {
    TollBooth(Double toll) {
        this.toll = toll;
        this.totalTollCollected = 0.0;
        this.numOfCarsNotPaidToll = 0;
        this.numOfCarsPassed = 0;
    }

    public void carPassed(Boolean paidToll) {
        this.numOfCarsPassed++;
        if (paidToll) {
            this.totalTollCollected += toll;
        } else {
            this.numOfCarsNotPaidToll++;
        }
    }

    @Override
    public String toString() {
        return "Number Of Cars Passed = " + numOfCarsPassed +
                "\nNumber Of Cars Not Paid Toll = " + numOfCarsNotPaidToll +
                "\nTotal Toll Collected = " + totalTollCollected;
    }

    private Double totalTollCollected;
    private Integer numOfCarsNotPaidToll;
    private Integer numOfCarsPassed;
    private final Double toll;
}
