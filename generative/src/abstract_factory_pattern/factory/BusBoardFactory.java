
package abstract_factory_pattern.factory;

import abstract_factory_pattern.board.Board;
import abstract_factory_pattern.board.BusBoard;
import abstract_factory_pattern.board.Passenger;
import abstract_factory_pattern.driver.Driver;

import java.util.List;


public class BusBoardFactory extends AbstractBoardFactory {
    public Board make(Driver driver, List<Passenger> passengers) throws Exception {
        BusBoard result = new BusBoard();
        result.setDriver(driver);
        result.addPassengers(passengers);
        return result;
    }
}
