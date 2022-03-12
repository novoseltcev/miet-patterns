public class Passenger extends PlanePart {

    public Passenger(double weight) {
        this._weight = weight;
    }

    @Override
    public double getSummaryWeight() {
        return _weight;
    }

    @Override
    public double getSummaryExtraPayment() {
        return extraPayment;
    }

    @Override
    public void setExtraPayment(double extraPayment) {
        this.extraPayment = extraPayment;
    }

    @Override
    public String toString() {
        return "⚬ ";
    }
}
