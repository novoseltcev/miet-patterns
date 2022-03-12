
package factory;

import board.Board;
import board.BusBoard;
import board.Passenger;
import driver.Driver;

import java.util.List;


public class BusBoardFactory extends AbstractBoardFactory {
    public Board make(Driver driver, List<Passenger> passengers) throws Exception {
        BusBoard result = new BusBoard();
        result.setDriver(driver);
        result.addPassengers(passengers);
        return result;
    }
}
