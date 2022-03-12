import board.Board;
import board.Passenger;
import driver.BusDriver;
import driver.TaxiDriver;
import factory.BusBoardFactory;
import factory.TaxiBoardFactory;

import java.util.LinkedList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        List<Passenger> taxiPassengers = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            taxiPassengers.add(new Passenger());
        }

        List<Passenger> busPassengers = new LinkedList<>();
        for (int i = 0; i < 51; i++) {
            busPassengers.add(new Passenger());
        }

        List<Board> schedule = new LinkedList<>();

        BusBoardFactory busFactory = new BusBoardFactory();
        while (!busPassengers.isEmpty()) {
            schedule.add(busFactory.make(BusDriver.getInstance(), busPassengers));
        }

        TaxiBoardFactory taxiFactory = new TaxiBoardFactory();
        while (!taxiPassengers.isEmpty()) {
            schedule.add(taxiFactory.make(TaxiDriver.getInstance(), taxiPassengers));
        }

        for (Board board : schedule) {
            System.out.println(board);
        }
    }
}
