package pl.com.knowosad.game.application;

import pl.com.knowosad.game.engine.game.Arbiter;
import pl.com.knowosad.game.engine.game.ArbiterFactory;
import pl.com.knowosad.game.engine.game.GameCount;
import pl.com.knowosad.game.engine.game.ScoreBoard;
import pl.com.knowosad.game.engine.sound.DeviceFactory;

public class GameAppOO {

    public static void main(String[] args) {
        try {
            Arbiter arbiter;
            short gamesCount;

            GameCount gc = new GameCount();
            gamesCount = gc.readGamesCount();

            ArbiterFactory af = new ArbiterFactory();
            arbiter = af.initPlayers(gamesCount);

            DeviceFactory device = new DeviceFactory();
            ScoreBoard primaryScore = new ScoreBoard(af.getPlayer1().getName(), af.getPlayer2().getName(), gamesCount, device.initializeDevice());

            Arbiter.GameResult result = null;
            int counter = 0;
            do {
                result = arbiter.playRound();
                primaryScore.refresh(result, counter, af.getPlayer1().getName(), af.getPlayer2().getName());
                counter++;
            } while (result != Arbiter.GameResult.GAME_OVER);
            System.out.println(arbiter.generateRaport());
        }
        catch (Exception e){
            System.out.println("nieoczekiwany błąd" + e.getMessage());
        }
    }
}
