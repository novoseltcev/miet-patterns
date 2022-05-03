package builder;

import entity.Driver;
import entity.DriverLicense;
import entity.Passenger;
import entity.PassengerType;

public class BusBuilder extends Builder {
    @Override
    void createDriver() {
        board.driver = new Driver(DriverLicense.D);
    }

    @Override
    void createPassengers() {
        for (var i = 0; i < 30 / 3; i++) {
            board.passengers.add(new Passenger(PassengerType.common));
            board.passengers.add(new Passenger(PassengerType.child));
            board.passengers.add(new Passenger(PassengerType.beneficiary));
        }
    }
}
