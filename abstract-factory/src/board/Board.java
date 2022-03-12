package board;

import driver.Driver;

import java.util.LinkedList;
import java.util.List;

public abstract class Board {
    int capacity;
    Driver driver;
    List<Passenger> passengers;

    Board(int capacity) {
        this.capacity = capacity;
        this.passengers = new LinkedList<>();
    }

    public Driver getDriver() {
        return driver;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setDriver(Driver driver) throws Exception {
        if (this.driver == null)
            this.driver = driver;
        else
            throw new Exception("Driver already on the abstract_factory.board");
    }

    public void removeDriver() {
        this.driver = null;
    }

    public void addPassengers(List<Passenger> passengers) {
        int space = Math.min(capacity - this.passengers.size(), passengers.size());
        for (int i = 0; i < space; i++) {
            Passenger passenger = passengers.remove(0);
            passenger.setStatus(PassengerStatus.ride);
            this.passengers.add(passenger);
        }
    }

    public abstract boolean isReady();
}
