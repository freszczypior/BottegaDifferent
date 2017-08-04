package pl.com.bottega.animalPlanet;

public class VegeES implements EatStrategy {

    @Override
    public void eat() {
        System.out.println("Jestem roślinożercą");
    }
}
