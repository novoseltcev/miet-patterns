import abstraction.Driver;
import abstraction.IFactory;
import abstraction.Passenger;

import java.util.List;

public class Board {
    Driver driver;
    List<Passenger> passengers;
    Board(IFactory factory) {
        driver = factory.createDriver();
        passengers = factory.createPassengers();
    }

    @Override
    public String toString() {
        return "Board { driver:" + driver + ", passengers: " + passengers.size() + "}";
    }
}
