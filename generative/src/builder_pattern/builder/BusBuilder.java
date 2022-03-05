package builder_pattern.builder;

import builder_pattern.Board;
import builder_pattern.DriverLicense;
import builder_pattern.Passenger;
import builder_pattern.PassengerType.*;

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
