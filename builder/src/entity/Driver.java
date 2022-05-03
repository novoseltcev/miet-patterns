package entity;

public class Driver {
    public final DriverLicense driverLicense;

    public Driver(DriverLicense license) {
        this.driverLicense = license;
    }

    @Override
    public String toString() {
        return "Driver{" + "driverLicense=" + driverLicense + '}';
    }
}
