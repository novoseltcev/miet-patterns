package build;

import entity.Board;
import entity.DriverLicense;
import entity.Passenger;

import java.util.Arrays;

public class BusBuilder extends BoardBuilder {

    public BusBuilder() {
        this.allowedLicenses = Arrays.asList(DriverLicense.D, DriverLicense.DE);
    }

    @Override
    public void createBoard() {
        this.board = new Board(30);
    }

    @Override
    public void calculateProcessing() {
        double sumProfit = 0;
        for (Passenger passenger : this.board.getPassengers()) {
            switch (passenger.getPassType()) {
                case child -> sumProfit += 30;
                case common -> sumProfit += 100;
                case beneficiary -> sumProfit += 25;
            }
        }
        this.board.setProfit(sumProfit);
    }


}
