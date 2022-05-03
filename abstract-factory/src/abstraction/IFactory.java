package abstraction;

import java.util.List;

public interface IFactory {
    Driver createDriver();
    List<Passenger> createPassengers();
}

