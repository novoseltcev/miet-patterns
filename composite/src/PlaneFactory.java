public class PlaneFactory {
    PlaneComposite make() {
        var plane = new PlaneComposite();
        var firstClass = new PlaneComposite();
        var businessClass = new PlaneComposite();
        var economyClass = new PlaneComposite();
        plane.add(firstClass);
        plane.add(businessClass);
        plane.add(economyClass);

        for (var i = 0; i < 2; i++) {
            plane.parts.add(new Passenger(PassengerType.pilot, 0));
        }
        for (var i = 0; i < 6; i++) {
            plane.parts.add(new Passenger(PassengerType.stewardess, 0));
        }
        return plane;
    }
}
