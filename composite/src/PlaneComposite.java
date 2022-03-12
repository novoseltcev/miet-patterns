import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PlaneComposite extends PlanePart {
    protected final List<PlanePart> parts;
    protected final int capacity;

    PlaneComposite(int capacity) {
        this.capacity = capacity;
        parts = new LinkedList<>();
    }

    @Override
    public List<PlanePart> getParts() {
        return parts;
    }

    @Override
    public void add(PlanePart part) {
        parts.add(part);
    }

    @Override
    public void add(Collection<PlanePart> parts) {
        this.parts.addAll(parts);
    }

    @Override
    public double getSummaryWeight() {
        return parts.stream().mapToDouble(PlanePart::getSummaryWeight).reduce(0., Double::sum);
    }

    @Override
    public double getSummaryExtraPayment() {
        return parts.stream().mapToDouble(PlanePart::getSummaryExtraPayment).reduce(0., Double::sum);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\t⚫\n");
        for (PlanePart part: parts) {
            stringBuilder.append(part);
        }
        return stringBuilder.toString();
    }
}
