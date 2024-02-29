package Ass1;

public class q1 {
    public static void main(String[] args) {
        new RoomDemo();
    }
}

class Room {
    private double height;
    private double width;
    private double breadth;

    public Room(double height, double width, double breadth) {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
    }

    public double volume() {
        return Math.floor(height * width * breadth * 1000) / 1000.0;
    }

    @Override
    public String toString() {
        return "Room [" +
                "Height: " + height + ", " +
                "Width: " + width + ", " +
                "Breadth: " + breadth + "]";
    }
}

class RoomDemo {
    RoomDemo() {
        Room room1 = new Room(3.5, 4.2, 5.8);
        Room room2 = new Room(2.8, 3.5, 4.0);

        System.out.println("Volume of " + room1 + ": " + room1.volume());
        System.out.println("Volume of " + room2 + ": " + room2.volume());
    }
}