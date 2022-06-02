import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        var plane = new PlaneFactory().make();
        loadPassengers(plane);
        System.out.println("Загрузка самолёта (кг): " + plane.getSummaryWeight());
        try {
            System.out.print("Введите максимальную загрузку: ");
            var maxWeight = new Scanner(System.in).nextDouble();

            var removedBaggage = checkPlaneCargo(plane, maxWeight);
            if (removedBaggage.size() > 0) {
                System.out.println("Кол-во снятого с рейса багажа: " + removedBaggage.size());
                System.out.println("Суммарный вес снятого с рейса багажа (кг): " + removedBaggage.stream().mapToDouble(Baggage::weight).reduce(0, Double::sum));
            }
            System.out.println("Выручка за превышение бесплатного лимита багажа ($): " + plane.getSummaryExtraPayment());

            System.out.println("\nКарта загрузки самолёта");
            System.out.println(getMap(plane));

            plane.parts.get(2).remove(1);

            System.out.println("\nКарта загрузки самолёта");
            System.out.println(getMap(plane));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void loadPassengers(PlaneComposite plane) {
        var firstClass = (PlaneComposite)plane.parts.get(0);
        var businessClass = (PlaneComposite)plane.parts.get(1);
        var economyClass = (PlaneComposite)plane.parts.get(2);
        var randomizer = new Random();

        for (var i = 0; i < randomizer.nextInt(3, 10); i++) {
            firstClass.parts.add(new Passenger(PassengerType.firstClass, randomizer.nextDouble(5, 60)));
        }

        for (var i = 0; i < randomizer.nextInt(10, 20); i++) {
            businessClass.parts.add(new Passenger(PassengerType.businessClass, randomizer.nextDouble(5, 60)));
        }

        for (var i = 0; i < randomizer.nextInt(80, 150); i++) {
            economyClass.parts.add(new Passenger(PassengerType.economyClass, randomizer.nextDouble(5, 60)));
        }
    }

    private static List<Baggage> checkPlaneCargo(PlaneComposite plane, double maxWeight) throws Exception {
        var result = new LinkedList<Baggage>();
        var weightExcess = plane.getSummaryWeight() - maxWeight;
        if (weightExcess > 0) {
            System.out.println("Превышение веса на " + weightExcess);
            PlaneComposite economyClass = (PlaneComposite) plane.parts.get(2);
            if (weightExcess > economyClass.getSummaryWeight()) {
                throw new Exception("Самолёт перегружен и рейс отменяется на пересборку: " + economyClass.getSummaryWeight());
            }
            var counter = 0;
            while (weightExcess > 0) {
                Passenger passenger = (Passenger) economyClass.parts.get(counter++);
                weightExcess -= passenger.getSummaryWeight();
                result.add(passenger.baggage);
                passenger.baggage = null;
            }
        }
        return result;
    }

    private static String getMap(PlaneComposite plane) {
        var firstClass = (PlaneComposite)plane.parts.get(0);
        var businessClass = (PlaneComposite)plane.parts.get(1);
        var economyClass = (PlaneComposite)plane.parts.get(2);

        var result = "";
        result += "First Class:\n";
        result += getClassMap(firstClass, 10);

        result += "\nBusiness Class:\n";
        result += getClassMap(businessClass, 20);

        result += "\nEconomy Class:\n";
        result += getClassMap(economyClass, 150);
        return result;
    }

    private static String getClassMap(PlaneComposite classMap, int size) {
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < size; i++) {
            if (classMap.parts.size() > i && classMap.parts.get(i) != null ) {
                result.append("● ");
            } else {
                result.append("◯ ");
            }
        }
        return result.toString();
    }
}
