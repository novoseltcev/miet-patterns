import java.util.LinkedList;
import java.util.List;

public class PlaneComposite extends PlanePart {
    protected final List<PlanePart> parts = new LinkedList<>();

    @Override
    public double getSummaryWeight() {
        return parts.stream().mapToDouble(PlanePart::getSummaryWeight).reduce(0., Double::sum);
    }

    @Override
    public double getSummaryExtraPayment() {
        return parts.stream().mapToDouble(PlanePart::getSummaryExtraPayment).reduce(0., Double::sum);
    }

    @Override
    public int add(PlanePart planePart) {
        parts.add(planePart);
        return parts.size();
    }

    @Override
    public void remove(int place) {
        parts.remove(place - 1);
    }
}
