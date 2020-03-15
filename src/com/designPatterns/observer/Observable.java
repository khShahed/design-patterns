package com.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

// Subject
public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(int value){
        for(Observer observer: observers){
            observer.update(value);
        }
    }
}
