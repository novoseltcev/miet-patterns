package builder;

import entity.Driver;
import entity.DriverLicense;
import entity.Passenger;
import entity.PassengerType;


public class TaxiBuilder extends Builder {
    @Override
    void createDriver() {
        board.driver = new Driver(DriverLicense.B);
    }

    @Override
    void createPassengers() {
        for (var i = 0; i < 4 / 2; i++) {
            board.passengers.add(new Passenger(PassengerType.common));
            board.passengers.add(new Passenger(PassengerType.child));
        }
    }
}
