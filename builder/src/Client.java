import build.BoardDirector;
import build.BusBuilder;
import build.TaxiBuilder;
import entity.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        BoardDirector director = new BoardDirector(getDrivers());

        List<Board> boards = getTaxiBoards(director, getTaxiQueue());
        boards.addAll(getBusBoards(director, getBusQueue()));

        for (Board board : boards) {
            System.out.println(board);
        }
    }

    static List<Passenger> getTaxiQueue() {
        List<Passenger> result = new LinkedList<>();
        for (int i = 0; i < 9; i += 3) {
            result.add(new Passenger(PassengerType.child));
            result.add(new Passenger(PassengerType.common));
            result.add(new Passenger(PassengerType.beneficiary));
        }
        return result;
    }

    static List<Passenger> getBusQueue() {
        List<Passenger> result = new LinkedList<>();
        for (int i = 0; i < 51; i += 3) {
            result.add(new Passenger(PassengerType.child));
            result.add(new Passenger(PassengerType.common));
            result.add(new Passenger(PassengerType.beneficiary));
        }
        return result;
    }

    static List<Driver> getDrivers() {
        Driver busDriver = new Driver(List.of(DriverLicense.D));
        Driver taxiDriver = new Driver(List.of(DriverLicense.B, DriverLicense.C));
        return Arrays.asList(busDriver, taxiDriver, busDriver.clone(), taxiDriver.clone());
    }

    static List<Board> getTaxiBoards(BoardDirector director, List<Passenger> taxiQueue) throws Exception {
        TaxiBuilder taxiBuilder = new TaxiBuilder();

        List<Board> result = new LinkedList<>();
        while (!taxiQueue.isEmpty()) {
            Board board = director.make(taxiBuilder, taxiQueue);
            if (board == null)
                break;

            result.add(board);
        }
        return result;
    }

    static List<Board> getBusBoards(BoardDirector director, List<Passenger> busQueue) throws Exception {
        BusBuilder busBuilder = new BusBuilder();

        List<Board> result = new LinkedList<>();
        while (!busQueue.isEmpty()) {
            Board board = director.make(busBuilder, busQueue);
            if (board == null)
                break;

            result.add(board);
        }
        return result;
    }
}
