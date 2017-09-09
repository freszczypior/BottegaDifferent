package pl.com.knowosad.game.engine.sound;

public class SonyDevice implements SoundDevice{

    @Override
    public void playSound(String sound) {
        System.out.println(sound);
    }
}
