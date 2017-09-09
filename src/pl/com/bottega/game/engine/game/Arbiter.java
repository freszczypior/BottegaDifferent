package pl.com.knowosad.game.engine.game;

import pl.com.knowosad.game.engine.player.Hand;
import pl.com.knowosad.game.engine.player.IllegalInputException;
import pl.com.knowosad.game.engine.player.Player;
import pl.com.knowosad.game.engine.player.SmartComputerPlayer;

public class Arbiter {

    public enum GameResult {
        P1, P2, TIE, GAME_OVER
    }

    private short courrentRound;
    short maxRounds;

    private Player player1;
    private Player player2;

    private String[] matchLog;

    public Arbiter(Player player1, Player player2, short maxRounds) {
        if (maxRounds <= 0 )
            throw new IllegalArgumentException("max rounds must be gt 0");
        if (player1 == null || player2 == null)
            throw new IllegalArgumentException("player can't be null");

        this.player1 = player1;
        this.player2 = player2;
        this.maxRounds = maxRounds;
        this.matchLog = new String[maxRounds];
    }

    public GameResult playRound() {
        if (courrentRound == maxRounds)
            return Arbiter.GameResult.GAME_OVER;
        Hand hand1;
        Hand hand2;
        try {
            hand1 = player1.giveHand();

            if (player2 instanceof SmartComputerPlayer) {
                SmartComputerPlayer smart = (SmartComputerPlayer) player2;
                smart.cheat(hand1);
            }

            hand2 = player2.giveHand();
        }catch (IllegalInputException e){
            throw new IllegalStateException("players are to stupid", e); // przepakowanie wyjątku w inny
        }
        GameResult result = calculateResult(hand1, hand2);
        addToLog(hand1, hand2, result);
        courrentRound++;
        return result;
    }

    //    public String generateRaport(){
//        String raport = "";
//        for (int i = 0; i < matchLog.length; i++) {
//            raport += i  + ". " + matchLog[i] + "\n";
//        }
//        return raport;
//        }
//public String generateRaport(){
//        String raport = "";
//        int i = 0;
//
//        for (String entry: matchLog){
//            raport += i  + ". " + entry + "\n";
//        }
//        return raport;
//        }
    public String generateRaport() {
        StringBuilder raport = new StringBuilder();
        int i = 0;
        for (String entry : matchLog) {
            raport.append(i).append(". ").append(entry).append("\n");
            i++;
        }
        return raport.toString();
    }


    private void addToLog(Hand hand1, Hand hand2, GameResult result) {
        matchLog[courrentRound] = player1.getName() + ": " + hand1 + " VS. " + player2.getName() + ": " + hand2 + " ==> " + result;
    }

    private static GameResult calculateResult(Hand hand1, Hand hand2) {
        if (hand1 == null || hand2 == null)
            return GameResult.TIE;
        if (hand1.betterThan(hand2))
            return GameResult.P1;
        if (hand2.betterThan(hand1))
            return GameResult.P2;
        return GameResult.GAME_OVER;
    }
}
