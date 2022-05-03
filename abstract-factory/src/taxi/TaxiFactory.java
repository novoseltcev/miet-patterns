package taxi;

import abstraction.Driver;
import abstraction.IFactory;
import abstraction.Passenger;

import java.util.LinkedList;
import java.util.List;


public class TaxiFactory implements IFactory {
    @Override
    public Driver createDriver() {
        return new TaxiDriver();
    }

    @Override
    public List<Passenger> createPassengers() {
        var result = new LinkedList<Passenger>();
        for (var i = 0; i < 4; i++) {
            result.add(new TaxiPassenger());
        }
        return result;
    }
}
