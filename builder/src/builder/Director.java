package builder;

import entity.*;


public record Director() {

    public Board createBoard(Builder builder) {
        builder.start();
        builder.createDriver();
        builder.createPassengers();

        return builder.getBoard();
    }
}
