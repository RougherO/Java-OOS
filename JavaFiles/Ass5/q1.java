package Ass5;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle of radius: " + radius);
    }

    private float radius;
}

class Rectangle implements Shape {
    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle of width: " + width + " height: " + height);
    }

    private float width;
    private float height;
}

class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(2.0f);
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(2.0f, 2.0f);
        }
        return null;
    }
}

public class q1 {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.createShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.createShape("RECTANGLE");
        shape2.draw();
    }
}
