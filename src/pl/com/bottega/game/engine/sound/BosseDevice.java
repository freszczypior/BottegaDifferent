package pl.com.knowosad.game.engine.sound;

public class BosseDevice implements SoundDevice {

    @Override
    public void playSound(String sound) {
        System.out.println(sound);
    }
}