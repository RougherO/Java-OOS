public class q16 {
    public static void main(String[] args) {
        Tomato myTomato = new Tomato(10.0);

        System.out.println(myTomato);
    }
}

interface Fruit {
    public Boolean hasAPeel();
}

interface Vegetable {
    public Boolean hasARoot();
}

class Tomato implements Fruit, Vegetable {
    Tomato(Double weight) {
        this.weight = weight;
        this.color = "Red";
    }

    Tomato(Double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Double weight() {
        return this.weight;
    }

    public void weight(Double weight) {
        this.weight = weight;
    }

    public String color() {
        return this.color;
    }

    public void color(String color) {
        this.color = color;
    }

    @Override
    public Boolean hasAPeel() {
        return true;
    }

    @Override
    public Boolean hasARoot() {
        return true;
    }

    @Override
    public String toString() {
        return "Tomato: " +
                "\nWeight: " + weight +
                "\nColor: '" + color + "'" +
                "\nIs Fruit: " + hasAPeel() +
                "\nIs Vegetable: " + hasARoot();
    }

    private Double weight;
    private String color;
}