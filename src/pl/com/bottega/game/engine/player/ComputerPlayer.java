package pl.com.knowosad.game.engine.player;

import java.util.Random;

public class ComputerPlayer extends NamedPlayer {

    private Random random = new Random();

    public ComputerPlayer(String name){
        super(name);
    }

    public Hand giveHand() {
        int randomChoice = random.nextInt(Hand.values().length);
        return Hand.values()[randomChoice];
    }
}
