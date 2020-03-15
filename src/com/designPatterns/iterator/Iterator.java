package com.designPatterns.iterator;

public interface Iterator {
    boolean hasNext();
    String current();
    void Next();
}
// We can use the following interface for type independent Iterator
//public interface Iterator<T> {
//    boolean hasNext();
//    T current();
//    void Next();
//}
