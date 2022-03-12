package build;

import entity.*;

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
