import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        PlaneBuilder planeBuilder = new PlaneBuilder();
        planeBuilder.create(5000);
        planeBuilder.putCrew(getCrew());
        planeBuilder.putOnFirstClass(getPassengers(10));
        planeBuilder.putOnBusinessClass(getPassengers(20));
        planeBuilder.putOnEconomyClass(getPassengers(150));
        try {
            List<Baggage> removedBaggage = planeBuilder.checkCargo();
            PlaneComposite plane = planeBuilder.get();

            System.out.println("Кол-во снятого с рейса багажа: " + removedBaggage.size());
            System.out.println("Суммарный вес снятого с рейса багажа (кг): " + removedBaggage.stream().mapToDouble(Baggage::getWeight).reduce(0, Double::sum));
            System.out.println("Загрузка самолёта (кг): " + plane.getSummaryWeight());
            System.out.println("Выручка за превышение бесплатного лимита багажа ($): " + plane.getSummaryExtraPayment());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static Collection<PlanePart> getCrew() {
        Collection<PlanePart> result = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            result.add(new Passenger(0));
        }
        return result;
    }

    private static Collection<PlanePart> getPassengers(int count) {
        Collection<PlanePart> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            Random rnd = new Random();
            result.add(new Passenger(rnd.nextDouble(5, 60)));
        }
        return result;
    }


}
