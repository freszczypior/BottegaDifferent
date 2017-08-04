package pl.com.bottega.smallestDigit;

import java.util.Scanner;

public class SmallestDigit {

    // Napisz funkcję która dla zadanej liczby całkowitej zwraca jej najmniejszą cyfrę

    public static void main(String[] args) {
        while (true) {
            System.out.println("podaj liczbę");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println(findSmallestDigit(number));
        }
    }

    public static int findSmallestDigit(int number){
        number = Math.abs(number);
        int smallest = number;
        while (number > 0) {
            int digit = number % 10;
            if (digit <= number) {
                smallest = digit;
            }
            number = number / 10;
        }
        return smallest;
    }
}
