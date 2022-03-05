package builder_pattern.builder;

import builder_pattern.*;

import java.util.LinkedList;
import java.util.List;

public abstract class BoardBuilder {
    Board board;
    List<DriverLicense> allowedLicenses;

    public abstract void createBoard();

    boolean isValidLicenses(List<DriverLicense> licenses) {
        return licenses.stream().filter(licence -> allowedLicenses.contains(licence)).toList().size() > 0;
    }

    public void chooseAndPinDriver(List<Driver> drivers) throws Exception {
        Driver driver = (Driver) drivers.stream().filter(_driver -> isValidLicenses(_driver.getLicenses())).toArray()[0];
        this.board.setDriver(driver);
//        drivers.remove(driver);
    }

    public void loadPassengers(List<Passenger> passengers) {
        int space = Math.min(this.board.getSpace(), passengers.size());
        List<Passenger> enteredPassengers = new LinkedList<>();
        for (int i = 0; i < space; i++) {
            Passenger passenger = passengers.remove(0);
            passenger.setStatus(PassengerStatus.ride);
            enteredPassengers.add(passenger);
        }
        this.board.addPassengers(enteredPassengers);
    }

    public boolean isReady() {
        return board.getPassengers().size() != 0 && board.getDriver() != null;
    }

    public Board getBoard() {
        Board result = board;
        board = null;
        return result;
    }

    public abstract void calculateProcessing();
}
