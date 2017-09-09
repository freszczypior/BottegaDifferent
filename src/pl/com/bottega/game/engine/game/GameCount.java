package pl.com.knowosad.game.engine.game;

import java.util.Scanner;

public class GameCount {

    public short readGamesCount() {
        System.out.println("podaj ilosc meczy do rozegrania: ");
        Scanner scanner = new Scanner(System.in);
        return (short) (scanner.nextInt());
    }
}
