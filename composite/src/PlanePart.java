import jdk.jshell.spi.ExecutionControl.NotImplementedException;

import java.util.Collection;
import java.util.List;


// Component
public abstract class PlanePart {
    protected double _weight;
    protected double extraPayment;


    public abstract double getSummaryWeight();
    public abstract double getSummaryExtraPayment();

    public void setExtraPayment(double extraPayment) throws NotImplementedException {
        throw new NotImplementedException("");
    }

    public List<PlanePart> getParts() throws NotImplementedException {
        throw new NotImplementedException("");
    }

    public void add(PlanePart part) throws NotImplementedException {
        throw new NotImplementedException("");
    }

    public void add(Collection<PlanePart> parts) throws NotImplementedException {
        throw new NotImplementedException("");
    }

}
