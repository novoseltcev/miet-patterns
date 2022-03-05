package builder_pattern.builder;

import builder_pattern.Board;
import builder_pattern.Passenger;
import builder_pattern.Driver;

import java.util.List;

public class BoardDirector {
    List<Driver> drivers;

    public BoardDirector(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Board make(BoardBuilder builder, List<Passenger> passengers) throws Exception {
        builder.createBoard();
        builder.chooseAndPinDriver(drivers);
        builder.loadPassengers(passengers);
        if (builder.isReady())
            builder.calculateProcessing();
            return builder.getBoard();
    }
}
