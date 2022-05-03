package builder;

import entity.*;

public abstract class Builder {
    Board board;

    void start() {
        board = new Board();
    }

    abstract void createDriver();
    abstract void createPassengers();

    Board getBoard() {
        return board;
    }
}
