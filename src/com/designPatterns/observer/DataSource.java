package com.designPatterns.observer;

public class DataSource extends Observable {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        System.out.println("Changing value..");
        this.value = value;
        this.notifyObservers();
    }
}
