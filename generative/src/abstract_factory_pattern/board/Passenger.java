package abstract_factory_pattern.board;

enum PassengerStatus{
    ride, wait
}

public class Passenger {
    PassengerStatus status = PassengerStatus.wait;

    public Passenger() {}

    public PassengerStatus getStatus() {
        return status;
    }

    public void setStatus(PassengerStatus status) {
        this.status = status;
    }
}
