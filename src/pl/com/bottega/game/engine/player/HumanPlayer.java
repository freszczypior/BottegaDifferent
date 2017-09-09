package pl.com.knowosad.game.engine.player;

import java.util.Scanner;

public class HumanPlayer extends NamedPlayer {

    private String hand;

    private static final String PAPER = "papier";
    private static final String ROCK = "kamien";
    private static final String SCISSORS = "nozyce";

    public static byte MAX_ERROR_ROUND = 3;

    private int allAttempts;    // zmienna zliczająca wszystkie błędne próby człowieka w całej grze

    public HumanPlayer(String name) {
        super(name);
    }

    public Hand giveHand() throws IllegalInputException {
        Hand hand = null;
        byte counter = 0;
        do{
            Scanner scanner = new Scanner(System.in);
            say(name + " wpisz: kamien, nozyce lub papier"); // dodałem wyświetlanie imienia humanPlayer
            String handString = scanner.nextLine();
            hand = Hand.fromPolishWords(handString);
            counter++;
        }while (wrongInput(hand) && doesNotExceedMaxLimit(counter));

        if (hand == null)
            throw new IllegalInputException("user exceeded " + MAX_ERROR_ROUND + " sttempts");

        return hand;
    }

    private boolean doesNotExceedMaxLimit(byte counter) {
        return counter <= MAX_ERROR_ROUND;
    }

    private boolean wrongInput(Hand hand) {
        return hand == null;
    }

    private void say(String s) {
        System.out.println(s);
    }

}
