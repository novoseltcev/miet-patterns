package abstract_factory_pattern;

import abstract_factory_pattern.board.Board;
import abstract_factory_pattern.board.Passenger;
import abstract_factory_pattern.driver.BusDriver;
import abstract_factory_pattern.driver.TaxiDriver;
import abstract_factory_pattern.factory.BusBoardFactory;
import abstract_factory_pattern.factory.TaxiBoardFactory;

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
