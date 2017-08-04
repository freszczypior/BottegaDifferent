package pl.com.bottega.animalPlanet;

public class WaterMS implements MoveStrategy {

    @Override
    public void move() {
        System.out.println("Poruszma się w wodzie");
    }
}
