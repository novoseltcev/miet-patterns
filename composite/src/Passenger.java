public class Passenger extends PlanePart {
    Baggage baggage;
    PassengerType type;
    double extraPayment;

    public Passenger(PassengerType type, double weight) {
        this.baggage = new Baggage(weight);
        this.type = type;
        switch (type) {
            case economyClass -> extraPayment = weight > 20 ? 100 : 0;
            case businessClass -> extraPayment = weight > 35 ? 50 : 0;
            default -> extraPayment = 0;
        }
    }

    @Override
    public double getSummaryWeight() {
        if (baggage == null)
            return 0;
        return baggage.weight();
    }

    @Override
    public double getSummaryExtraPayment() {
        return extraPayment;
    }
}
