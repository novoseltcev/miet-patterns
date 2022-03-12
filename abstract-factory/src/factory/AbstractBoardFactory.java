package factory;

import board.Board;
import board.Passenger;
import driver.Driver;

import java.util.List;

public abstract class AbstractBoardFactory {
    public abstract Board make(Driver driver, List<Passenger> passengers) throws Exception;
}

