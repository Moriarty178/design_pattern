package behavioral_patterns.observer_pattern_.observer;

public interface Observer<T> { // interface observer: cung cap 1 method cho con
    void update(T event);
}
