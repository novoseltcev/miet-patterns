package bus;

import abstraction.Driver;
import abstraction.IFactory;
import abstraction.Passenger;

import java.util.LinkedList;
import java.util.List;


public class BusFactory implements IFactory {
    @Override
    public Driver createDriver() {
        return new BusDriver();
    }

    @Override
    public List<Passenger> createPassengers() {
        var result = new LinkedList<Passenger>();
        for (var i = 0; i < 30; i++) {
            result.add(new BusPassenger());
        }
        return result;
    }
}
