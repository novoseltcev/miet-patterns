import java.util.Random;

public class PlaneBuilder {
    private PlaneComposite plane;
    private final Random randomizer = new Random();

    public void create() {
        plane = new PlaneComposite();
    }

    public void createCrew() {
        for (var i = 0; i < 2; i++) {
            plane.parts.add(new Passenger(PassengerType.pilot, 0));
        }
        for (var i = 0; i < 6; i++) {
            plane.parts.add(new Passenger(PassengerType.stewardess, 0));
        }
    }

    public void createFirstClass() {
        var firstClass = new PlaneComposite();
        for (var i = 0; i < 10; i++) {
            firstClass.parts.add(new Passenger(PassengerType.firstClass, randomizer.nextDouble(5, 60)));
        }
        plane.parts.add(firstClass);
    }

    public void createBusinessClass() {
        var businessClass = new PlaneComposite();
        for (var i = 0; i < 20; i++) {
            businessClass.parts.add(new Passenger(PassengerType.businessClass, randomizer.nextDouble(5, 60)));
        }
        plane.parts.add(businessClass);
    }

    public PlaneComposite createEconomyClass() {
        var economyClass = new PlaneComposite();
        for (var i = 0; i < 150; i++) {
            economyClass.parts.add(new Passenger(PassengerType.economyClass, randomizer.nextDouble(5, 60)));
        }
        plane.parts.add(economyClass);
        return economyClass;
    }

    public PlanePart get() {
        return plane;
    }
}
