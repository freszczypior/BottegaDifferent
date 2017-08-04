package pl.com.bottega.animalPlanet;

public class Animal {

    private String name;
    private MoveStrategy moveStrategy;
    private EatStrategy eatStrategy;

    Animal(String name, MoveStrategy moveStrategy, EatStrategy eatStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.eatStrategy = eatStrategy;
    }

    void presentYourself() {
        System.out.println("Cześć to ja " + name);
        this.eatStrategy.eat();
        this.moveStrategy.move();
    }
}
