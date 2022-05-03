import bus.BusFactory;
import taxi.TaxiFactory;

import java.util.LinkedList;


public class FactoryClient {
    public static void main(String[] args) {
        var nBus = 5;
        var nTaxi = 8;

        var schedule = new LinkedList<Board>();

        var busFactory = new BusFactory();
        for (var i = 0; i < nBus; i++) {
            schedule.add(new Board(busFactory));
        }

        var taxiFactory = new TaxiFactory();
        for (var i = 0; i < nTaxi; i++) {
            schedule.add(new Board(taxiFactory));
        }

        var i = 0;
        for (Board board : schedule) {
            System.out.println((i++) + " | " + board.toString());
        }
    }
}
