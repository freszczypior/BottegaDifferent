package pl.com.knowosad.game.engine.game;


import pl.com.knowosad.game.engine.sound.SoundDevice;

public class ScoreBoard {

    private short points1;
    private short points2;

    private String name1;
    private String name2;

    private short maxRounds;

    private SoundDevice soundDev;
    private String soundOfVictory = "FANFARY!!";

    public ScoreBoard(String name1, String name2, short maxRounds, SoundDevice soundDevice) {
        if (name1 == null || name1.trim().equals(""))
            throw new IllegalArgumentException("name can't be null");
        if (name2 == null || name2.trim().equals(""))
            throw new IllegalArgumentException("name can't be null");
        if (maxRounds <= 0)
            throw new IllegalArgumentException("max rounds must be gt 0");
        if (soundDevice == null)
            throw new IllegalArgumentException("sound can't be null");

        this.name1 = name1;
        this.name2 = name2;
        this.maxRounds = maxRounds;
        this.soundDev = soundDevice;
    }

    public void refresh(Arbiter.GameResult result, int counter, String name1, String name2) {
        if (result == Arbiter.GameResult.TIE) {
            displaySummary(counter, name1, name2);
            return;
        }
        switch (result) {
            case P1:
                points1++;
                break;
            case P2:
                points2++;
        }
        displayCurrentState(counter);
    }

    private void displayCurrentState(int counter) {
        say("round " + (counter + 1) + ": " + name1 + ": " + points1 + " VS " + name2 + ": " + points2);
    }

    private void displaySummary(int counter, String name1, String name2) {
        displayCurrentState(counter);
        if (points1 == points2)
            say("remis");
        else {
            String winner = points1 > points2 ? name1 : name2;
            say("mecz wygrał: " + winner);
            soundDev.playSound(soundOfVictory);
        }
    }

    private void say(String s) {
        System.out.println(s);
    }

}
