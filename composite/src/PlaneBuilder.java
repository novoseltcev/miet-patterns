import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PlaneBuilder {
    private int cargoWeight;
    private PlaneComposite plane;
    private PlaneComposite firstClass;
    private PlaneComposite businessClass;
    private PlaneComposite economyClass;

    public void create(int cargoWeight) {
        this.cargoWeight = cargoWeight;
        plane = new PlaneComposite(2 + 6 + 3);
        firstClass = new PlaneComposite(10);
        businessClass = new PlaneComposite(20);
        economyClass = new PlaneComposite(150);
        plane.add(firstClass);
        plane.add(businessClass);
        plane.add(economyClass);
    }

    public void putCrew(Collection<PlanePart> crew) {
        plane.add(crew);
    }

    public void putOnFirstClass(Collection<PlanePart> passengers) {
        firstClass.add(passengers);
    }

    public void putOnBusinessClass(Collection<PlanePart> passengers) {
        for (PlanePart pass : passengers) {
            Passenger passenger = (Passenger) pass;
            if (passenger.getSummaryWeight() > 35) {
                passenger.setExtraPayment(500);
            }
        }
        businessClass.add(passengers);
    }

    public void putOnEconomyClass(Collection<PlanePart> passengers) {
        for (PlanePart pass : passengers) {
            Passenger passenger = (Passenger) pass;
            if (passenger.getSummaryWeight() > 20) {
                passenger.setExtraPayment(300);
            }
        }
        economyClass.add(passengers);
    }

    public List<Baggage> checkCargo() throws Exception {
        List<Baggage> removedBaggage = new LinkedList<>();
        if (plane.getSummaryWeight() - cargoWeight - economyClass.getSummaryWeight() > 0) {
            throw new Exception("Самолёт перегружен и рейс отменяется на пересборку");
        }
        int counter = 0;
        while (plane.getSummaryWeight() - cargoWeight > 0) {
            Passenger passenger = (Passenger) economyClass.getParts().get(counter++);
            Baggage baggage = new Baggage(passenger.getSummaryWeight());
            removedBaggage.add(baggage);
            passenger._weight = 0;
        }
        return removedBaggage;
    }

    public PlaneComposite get() {
        return plane;
    }
}
