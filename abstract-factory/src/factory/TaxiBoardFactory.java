package factory;

import board.Board;
import board.Passenger;
import board.TaxiBoard;
import driver.Driver;

import java.util.List;

public class TaxiBoardFactory extends AbstractBoardFactory{

    @Override
    public Board make(Driver driver, List<Passenger> passengers) throws Exception {
        TaxiBoard result = new TaxiBoard();
        result.setDriver(driver);
        result.addPassengers(passengers);
        return result;
    }
}
