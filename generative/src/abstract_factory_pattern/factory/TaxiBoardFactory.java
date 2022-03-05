package abstract_factory_pattern.factory;

import abstract_factory_pattern.board.Board;
import abstract_factory_pattern.board.Passenger;
import abstract_factory_pattern.board.TaxiBoard;
import abstract_factory_pattern.driver.Driver;

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
