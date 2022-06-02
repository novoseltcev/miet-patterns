import jdk.jshell.spi.ExecutionControl;

public abstract class PlanePart {
    public abstract double getSummaryWeight();
    public abstract double getSummaryExtraPayment();

    public int add(PlanePart planePart) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("");
    }

    public void remove(int place) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("");
    }
}
