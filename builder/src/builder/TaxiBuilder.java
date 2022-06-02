package builder;

import entity.*;


public class TaxiBuilder extends Builder {
    @Override
    void setTypeName() {
        board.name = "Taxi";
    }

    @Override
    void createDriver() {
        board.driver = new Driver(DriverLicense.B);
    }

    @Override
    void createPassengers() {
        for (var i = 0; i < 3; i++) {
            board.passengers.add(new Passenger(PassengerType.common));
        }
        board.passengers.add(new Passenger(PassengerType.child));
    }

    @Override
    void createSafetyObjects() {
        for (var i = 0; i < 4; i++) {
            board.safetyObjects.add(new SafetyObject(SafetyObjectType.seatBelt));
        }
        board.safetyObjects.add(new SafetyObject(SafetyObjectType.childSeat));

    }
}
