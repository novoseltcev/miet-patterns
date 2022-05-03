package entity;

public class Passenger {
    PassengerStatus status = PassengerStatus.wait;
    PassengerType type;

    public Passenger(PassengerType type) {
        this.type = type;
    }

    public void setStatus(PassengerStatus status) {
        this.status = status;
    }

    public PassengerType getPassType() {
        return type;
    }
}
