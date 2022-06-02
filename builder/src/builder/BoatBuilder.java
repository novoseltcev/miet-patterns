package builder;

import entity.*;

public class BoatBuilder extends Builder {
    @Override
    void setTypeName() {
        board.name = "Boat";
    }

    @Override
    void createDriver() {
        board.driver = new Driver(DriverLicense.W);
    }

    @Override
    void createPassengers() {
        for (var i = 0; i < 8; i++) {
            board.passengers.add(new Passenger(PassengerType.common));
        }
    }

    @Override
    void createSafetyObjects() {
        for (var i = 0; i < 8; i++) {
            board.safetyObjects.add(new SafetyObject(SafetyObjectType.lifeJacket));
        }
    }
}
