package abstract_factory_pattern.driver;

import java.util.Collections;

public class TaxiDriver extends Driver{
    TaxiDriver() {
        super(Collections.singletonList(DriverLicense.B));
    }

    static TaxiDriver instance;

    public static TaxiDriver getInstance() {
        if (instance == null) {
            instance = new TaxiDriver();
        } return instance;
    }
}
