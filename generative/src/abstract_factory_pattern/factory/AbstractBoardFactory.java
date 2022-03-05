package abstract_factory_pattern.factory;

import abstract_factory_pattern.board.Board;
import abstract_factory_pattern.board.Passenger;
import abstract_factory_pattern.driver.Driver;

import java.util.List;

public abstract class AbstractBoardFactory {
    public abstract Board make(Driver driver, List<Passenger> passengers) throws Exception;
}

