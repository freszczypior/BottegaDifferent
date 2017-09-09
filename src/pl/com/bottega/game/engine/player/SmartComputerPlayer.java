package pl.com.knowosad.game.engine.player;


public class SmartComputerPlayer extends ComputerPlayer {

    private static final int CONSCIENCE_RATIO = 3;
    private Hand oopponentHand;

    private byte countOpponentHand;

    public SmartComputerPlayer(String name) {
        super(name);
    }

    public void cheat(Hand opponentHand) {
        this.oopponentHand = opponentHand;
    }

    @Override
    public Hand giveHand() {
        countOpponentHand++;
        if (countOpponentHand % CONSCIENCE_RATIO == 0) {
            return strongerHand();
        }
        return super.giveHand();
    }

    private Hand strongerHand() {
        for (Hand hand : Hand.values()) {
            if (hand.betterThan(oopponentHand))
                return hand;
        }
        return null;
    }
}
