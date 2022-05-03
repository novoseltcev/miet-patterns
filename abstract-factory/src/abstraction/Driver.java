package abstraction;

public abstract class Driver {
    public DriverLicense driverLicense;

    @Override
    public String toString() {
        return "Driver {driverLicense=" + driverLicense.name() + "}";
    }
}
