package entity;

import java.util.LinkedList;
import java.util.List;


public class Board {
    public String name;
    public Driver driver;
    public final List<Passenger> passengers = new LinkedList<>();
    public List<SafetyObject> safetyObjects = new LinkedList<>();

    @Override
    public String toString() {
        return name + " {driver=" + driver +
                ", passengers=" + passengers.size() +
                ", safetyObjects=" + safetyObjects.size() +
                '}';
    }

}
