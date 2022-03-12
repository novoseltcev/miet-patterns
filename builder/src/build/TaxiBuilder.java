package build;

import entity.Board;
import entity.DriverLicense;

import java.util.Arrays;


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
