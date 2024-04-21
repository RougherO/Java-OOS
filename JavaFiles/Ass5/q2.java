package Ass5;

interface Pizza {
    String getDescription();

    double getCost();
}

class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}

class TomatoDecorator extends PizzaDecorator {
    public TomatoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Tomato";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.5;
    }
}

public class q2 {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();

        pizza = new CheeseDecorator(pizza);

        pizza = new TomatoDecorator(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: Rs." + pizza.getCost());
    }
}
