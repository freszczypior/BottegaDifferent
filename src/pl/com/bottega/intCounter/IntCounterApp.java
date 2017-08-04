package pl.com.bottega.intCounter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntCounterApp {

    //Napisz funkcję, która dla zadanej liczby całkowitej, zwraca sumę jej cyfr.


    static private Scanner scanner = new Scanner(System.in);
    static private int number = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("podaj inta");
            try {
                number = scanner.nextInt();
            }catch (InputMismatchException exc){
                System.out.println("podaj warość typu int");
                continue;
            }
            System.out.println(countSum(number));
        }
    }
    public static int countSum(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number != 0) {
            sum += number % 10;
            number = number /10;
        }
        return sum;
    }

}
