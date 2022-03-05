package builder_pattern;

import java.util.LinkedList;
import java.util.List;


public class Board {
    int capacity;
    Driver driver;
    List<Passenger> passengers;
    double profit;

    public Board(int capacity) {
        this.capacity = capacity;
        this.passengers = new LinkedList<>();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) throws Exception {
        if (this.driver == null)
            this.driver = driver;
        else
            throw new Exception("Driver already on the abstract_factory.board");
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void removeDriver() {
        this.driver = null;
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public int getSpace(){
        return capacity - passengers.size();
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Board{");
        sb.append("capacity=").append(capacity);
        sb.append(", driver=").append(driver.id);
        sb.append(", passengers=").append(passengers.size());
        sb.append(", profit=").append(profit);
        sb.append('}');
        return sb.toString();
    }
}
