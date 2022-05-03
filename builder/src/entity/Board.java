package entity;

import java.util.LinkedList;
import java.util.List;


public class Board {
    public Driver driver;
    public final List<Passenger> passengers;

    public Board() {
        this.passengers = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Board{" +
                ", driver=" + driver +
                ", passengers=" + passengers.size() +
                '}';
    }

}
