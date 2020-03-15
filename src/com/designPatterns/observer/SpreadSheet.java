package com.designPatterns.observer;

public class SpreadSheet implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Spread sheet updated.");
    }
}
