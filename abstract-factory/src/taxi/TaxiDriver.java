package taxi;

import abstraction.Driver;
import abstraction.DriverLicense;

public class TaxiDriver extends Driver {
    TaxiDriver() {
        driverLicense = DriverLicense.B;
    }
}
