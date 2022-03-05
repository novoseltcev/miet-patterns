package builder_pattern.builder;

import builder_pattern.Board;
import builder_pattern.Passenger;
import builder_pattern.DriverLicense;

import java.util.Arrays;
import java.util.List;


public class TaxiBuilder extends BoardBuilder {
    public TaxiBuilder() {
        this.allowedLicenses = Arrays.asList(DriverLicense.B, DriverLicense.BE);
    }

    @Override
    public void createBoard() {
        this.board = new Board(4);
    }

    @Override
    public void calculateProcessing() {
        this.board.setProfit(1000.);
    }


}
