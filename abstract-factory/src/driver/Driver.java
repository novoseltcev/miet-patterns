package driver;

import java.util.List;

public abstract class Driver {
    static int counter = 0;
    int id;
    List<DriverLicense> driverLicenses;

    Driver(List<DriverLicense> licenses) {
        this.id = counter++;
        this.driverLicenses = licenses;
    }

    public List<DriverLicense> getLicenses() {
        return driverLicenses;
    }
}
