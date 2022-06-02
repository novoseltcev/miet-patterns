package builder;

import entity.Board;


public record Director() {

    public Board createBoard(Builder builder) {
        builder.start();
        builder.setTypeName();
        builder.createDriver();
        builder.createPassengers();
        builder.createSafetyObjects();

        return builder.getBoard();
    }
}
