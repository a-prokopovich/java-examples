package com.prokopovich.aggregation.solid.spr;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private double price;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza: " +
                "name = " + name +
                ", price = " + price;
    }
}

public class Order {
    private int id;
    private List<Pizza> pizzas;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void showOrder() {
        System.out.println("id: " + id);
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.toString());
        }
    }

    public void addOrder(int id, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
    }
}

public class CalculateOrder {
    private double totalCost;

    public CalculateOrder() {
        this.totalCost = 0;
    }

    public double calculateOrderCost(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            totalCost += pizza.getPrice();
        }
        return totalCost;
    }
}

public class Main {

    public static void main(String[] args) {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Pepperoni", 12.5));
        pizzas.add(new Pizza("Hawaiian", 18.5));
        Order order = new Order();
        order.addOrder(1, pizzas);
        CalculateOrder calculateOrder = new CalculateOrder();
        System.out.println("Your order: ");
        order.showOrder();
        System.out.println("Total order cost: " + calculateOrder.calculateOrderCost(order));
    }
}
