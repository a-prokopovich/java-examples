package com.prokopovich.solid.isp;

public interface Person {
    void eat();
    void sleep();
}

public interface Employee {
    void work();
}

public class Unemployed implements Person {
    private String name;

    public Unemployed(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " eats");
    }

    @Override
    public void sleep() {
        System.out.println(name + " sleeps");
    }
}

public class WorkingPerson implements Person, Employee {
    private String name;
    private String position;

    public WorkingPerson(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void eat() {
        System.out.println(name + " eats");
    }

    @Override
    public void sleep() {
        System.out.println(name + " sleeps");
    }

    @Override
    public void work() {
        System.out.println(name + " works as a " + position);
    }
}

public class Main {

    public static void main(String[] args) {
        Unemployed unemployed = new Unemployed("Mark");
        unemployed.eat();
        unemployed.sleep();
        WorkingPerson employee = new WorkingPerson("Ann", "Teacher");
        employee.sleep();
        employee.work();
        employee.eat();
    }
}
