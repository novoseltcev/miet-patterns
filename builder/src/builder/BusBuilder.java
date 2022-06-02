package builder;

import entity.*;

public class BusBuilder extends Builder {
    @Override
    void setTypeName() {
        board.name = "Bus";
    }

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

    @Override
    void createSafetyObjects() {
        for (var i = 0; i < 30; i++) {
            board.safetyObjects.add(new SafetyObject(SafetyObjectType.seatBelt));
        }
    }
}
