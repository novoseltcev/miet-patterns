package builder;

import entity.*;

public abstract class Builder {
    Board board;

    void start() {
        board = new Board();

    }

    abstract void setTypeName();
    abstract void createDriver();
    abstract void createPassengers();

    abstract void createSafetyObjects();

    Board getBoard() {
        return board;
    }
}
