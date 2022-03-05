package abstract_factory_pattern.driver;

import java.util.Collections;

public class BusDriver extends Driver {
    static BusDriver instance;

    public static BusDriver getInstance() {
        if (instance == null) {
            instance = new BusDriver();
        } return instance;
    }

    BusDriver() {
        super(Collections.singletonList(DriverLicense.D));
    }
}
