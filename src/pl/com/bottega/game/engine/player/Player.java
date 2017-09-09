package pl.com.knowosad.game.engine.player;

public interface Player {

    Hand giveHand() throws IllegalInputException;

    String getName();
}
