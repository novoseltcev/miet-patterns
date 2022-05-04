import interfaces.*;

import java.util.LinkedList;
import java.util.List;

public class Teacher implements Observable {
    private final String ID;
    private final List<Observer> _observers;

    public Teacher(String ID) {
        this.ID = ID;
        _observers = new LinkedList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        _observers.add(observer);
    }

    @Override
    public void rmObserver(Observer observer) {
        _observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (var observer: _observers) {
            observer.update(ID);
        }
    }
}
