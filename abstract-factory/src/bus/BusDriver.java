package bus;

import abstraction.Driver;
import abstraction.DriverLicense;

public class BusDriver extends Driver {
    BusDriver() {
        driverLicense = DriverLicense.D;
    }
}
