package abstract_factory_pattern.board;

import abstract_factory_pattern.driver.DriverLicense;

public class BusBoard extends Board {

    public BusBoard() {
        super(30);
    }

    @Override
    public boolean isReady() {
        if (passengers.size() == 0 || driver == null)
            return false;
        return driver.getLicenses().contains(DriverLicense.D) || driver.getLicenses().contains(DriverLicense.DE);
    }

    @Override
    public String toString() {
        return "BusBoard { passengers: " + passengers.size() + ", ready: " + isReady() + " }";
    }
}
