package pl.com.knowosad.game.engine.game;

import pl.com.knowosad.game.engine.player.ComputerPlayer;
import pl.com.knowosad.game.engine.player.HumanPlayer;
import pl.com.knowosad.game.engine.player.Player;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ArbiterFactory {

    private Player player1; // TODO spr jaka klasa powinna być, podawanie imienia
    private Player player2;
    private Scanner scanner = new Scanner(System.in);

    public Arbiter initPlayers(short gamesCount) {
        int choice;
        do {
            say("wybierz graczy:");
            say("1. computer vs computer");
            say("2. human vs human");
            say("3. human vs computer");
            choice = scanner.nextInt();
            clearScanner();
        } while (!Pattern.matches("[1-3]", String.valueOf(choice)));
        switch (choice) {
            case 1:
                player1 = createComputerPlayer();
                player2 = createComputerPlayer();
                break;
            case 2:
                say("podaj imie gracza nr 1:");
                player1 = createHumanPlayer();
                say("podaj imie gracza nr 2");
                player2 = createHumanPlayer();
                break;
            case 3:
                say("podaj imie gracza:");
                player1 = createHumanPlayer();
                player2 = createComputerPlayer();
                break;
        }
        return createArbiter(player1, player2, gamesCount);
    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    private Player createHumanPlayer() {
        return new HumanPlayer(scanner.nextLine());
    }

    private Player createComputerPlayer() {
        return new ComputerPlayer("asdf");
    }

    private Arbiter createArbiter(Player player1, Player player2, short gamesCount) {
        return new Arbiter(player1, player2, gamesCount);
    }
    private void clearScanner() {
        scanner.nextLine();
    }

    private void say(String s) {
        System.out.println(s);
    }
}
