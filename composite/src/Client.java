import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        PlaneBuilder planeBuilder = new PlaneBuilder();
        planeBuilder.create();
        planeBuilder.createCrew();
        planeBuilder.createFirstClass();
        planeBuilder.createBusinessClass();
        var economyClass = planeBuilder.createEconomyClass();
        var plane = planeBuilder.get();
        System.out.println("Загрузка самолёта (кг): " + plane.getSummaryWeight());
        try {
            System.out.print("Введите максимальную загрузку: ");
            var maxWeight = new Scanner(System.in).nextDouble();
            var removedBaggage = checkPlaneCargo(plane, economyClass, maxWeight);
            if (removedBaggage.size() > 0) {
                System.out.println("Кол-во снятого с рейса багажа: " + removedBaggage.size());
                System.out.println("Суммарный вес снятого с рейса багажа (кг): " + removedBaggage.stream().mapToDouble(Baggage::weight).reduce(0, Double::sum));
            }
            System.out.println("Выручка за превышение бесплатного лимита багажа ($): " + plane.getSummaryExtraPayment());
            System.out.println("Борт отправляется");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private static List<Baggage> checkPlaneCargo(PlanePart plane, PlaneComposite economyClass, double maxWeight) throws Exception {
        var result = new LinkedList<Baggage>();
        var weightExcess = plane.getSummaryWeight() - maxWeight;
        if (weightExcess > 0) {
            System.out.println("Превышение веса на " + weightExcess);
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
}
