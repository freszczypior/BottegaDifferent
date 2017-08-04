package pl.com.bottega.animalPlanet;

public class AirMS implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Poruszam się w powietrzu");
    }
}
