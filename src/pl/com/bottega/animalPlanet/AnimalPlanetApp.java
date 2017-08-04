package pl.com.bottega.animalPlanet;


import java.util.Scanner;

public class AnimalPlanetApp {

    private static Animal Animals[] = new Animal[6];

    public static void main(String[] args) {

        createAnimalTab();
        while (true) {
           showMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice < 1 || choice >Animals.length){
                say("błędny wybór");
                continue;
            }else
            Animals[choice-1].presentYourself();
        }
    }
    static void say(String s){
        System.out.println(s);
    }
    static void showMenu(){
        say("*********************");
        say("Encyklopedia zwierząt:");
        say("1. lew");
        say("2. koń");
        say("3. mewa");
        say("4. sokół");
        say("5. wieloryb");
        say("6. rekin");
        say("*********************");
        say("Wybierz: ");
    }
    static void createAnimalTab(){
        Animals[0] = new Animal("lew", new LandMS(), new MeetES());
        Animals[1] = new Animal("koń", new LandMS(), new VegeES());
        Animals[2] = new Animal("mewa", new AirMS(), new MeetES());
        Animals[3] = new Animal("sokół", new AirMS(), new MeetES());
        Animals[4] = new Animal("wieloryb", new WaterMS(), new MeetES());
        Animals[5] = new Animal("rekin", new WaterMS(), new MeetES());
    }
}
