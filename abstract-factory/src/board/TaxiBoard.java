package board;

import driver.DriverLicense;

public class TaxiBoard extends Board {

    public TaxiBoard() {
        super(4);
    }

    @Override
    public boolean isReady() {
        if (passengers.size() == 0 || driver == null)
            return false;
        return driver.getLicenses().contains(DriverLicense.B) || driver.getLicenses().contains(DriverLicense.BE);
    }

    @Override
    public String toString() {
        return "TaxiBoard { passengers: " + passengers.size() + ", ready: " + isReady() + " }";
    }
}
