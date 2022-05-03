import builder.BusBuilder;
import builder.Director;
import builder.TaxiBuilder;
import entity.Board;

import java.util.LinkedList;

public class BuilderClient {
    public static void main(String[] args) {
        var nBus = 5;
        var nTaxi = 8;

        var schedule = new LinkedList<Board>();

        var director = new Director();
        var busBuilder = new BusBuilder();
        for (var i = 0; i < nBus; i++) {
            schedule.add(director.createBoard(busBuilder));
        }

        var taxiBuilder = new TaxiBuilder();
        for (var i = 0; i < nTaxi; i++) {
            schedule.add(director.createBoard(taxiBuilder));
        }

        var i = 0;
        for (Board board : schedule) {
            System.out.println((i++) + " | " + board.toString());
        }
    }
}
