import java.util.List;

public class q14 {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.0);
        Circle c2 = new Circle(4.0);

        Rectangle r1 = new Rectangle(1.0, 2.0);
        Rectangle r2 = new Rectangle(3.0, 4.0);
        Rectangle r3 = new Rectangle(5.0, 6.0);

        for (Shape shape : List.of(c1, c2, r1, r2, r3)) {
            System.out.println("\nInitial Configuration: ");
            shape.draw();
            shape.move(1.0, 1.0);
            shape.rotate(60.0);
            System.out.println("\nFinal Configuration: ");
            shape.draw();
        }
    }
}

interface Shape {
    public Double area();

    public void draw();

    public void move(Double x, Double y);

    public void rotate(Double angleInRadians);

    public Double getXCoord();

    public Double getYCoord();

    public Double getRotation();
}

class Circle implements Shape {
    Circle(Double radius) {
        this.xCoord = 0.0;
        this.yCoord = 0.0;
        this.rotation = 0.0;
        this.radius = radius;
    }

    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println(this.toString());
    }

    @Override
    public void move(Double x, Double y) {
        this.xCoord += x;
        this.yCoord += y;
    }

    @Override
    public void rotate(Double angleInDegrees) {
        this.rotation += Math.toRadians(angleInDegrees);
    }

    @Override
    public Double getXCoord() {
        return this.xCoord;
    }

    @Override
    public Double getYCoord() {
        return this.yCoord;
    }

    @Override
    public Double getRotation() {
        return this.rotation;
    }

    @Override
    public String toString() {
        return "\nCoords: [" +
                this.xCoord + ", " +
                this.yCoord + "]" +
                "\nRadius: " + this.radius +
                "\nRotation: " + Math.floor(Math.toDegrees(this.rotation) * 1000) / 1000.0;

    }

    private Double radius;
    private Double xCoord;
    private Double yCoord;
    private Double rotation;
}

class Rectangle implements Shape {
    Rectangle(Double length, Double breadth) {
        this.xCoord = 0.0;
        this.yCoord = 0.0;
        this.rotation = 0.0;
        this.length = length;
        this.breadth = breadth;
    }

    public Double getLength() {
        return this.length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getBreadth() {
        return this.breadth;
    }

    public void setBreadth(Double breadth) {
        this.breadth = breadth;
    }

    @Override
    public Double area() {
        return length * length;
    }

    @Override
    public void draw() {
        System.out.println(this.toString());
    }

    @Override
    public void move(Double x, Double y) {
        this.xCoord += x;
        this.yCoord += y;
    }

    @Override
    public void rotate(Double angleInDegrees) {
        this.rotation += Math.toRadians(angleInDegrees);
    }

    @Override
    public Double getXCoord() {
        return this.xCoord;
    }

    @Override
    public Double getYCoord() {
        return this.yCoord;
    }

    @Override
    public Double getRotation() {
        return this.rotation;
    }

    @Override
    public String toString() {
        return "\nCoords: [" +
                this.xCoord + ", " +
                this.yCoord + "]" +
                "\nLength: " + this.length +
                "\nBreadth: " + this.breadth +
                "\nRotation: " + Math.floor(Math.toDegrees(this.rotation) * 1000) / 1000.0;

    }

    private Double length;
    private Double breadth;
    private Double xCoord;
    private Double yCoord;
    private Double rotation;
}