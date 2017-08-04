package pl.com.bottega.animalPlanet;

public class MeetES implements EatStrategy {
    @Override
    public void eat() {
        System.out.println("Jestem mięsożercą");
    }
}
