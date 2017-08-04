package pl.com.bottega.smallestDigit;

import java.util.Scanner;

public class SmallestDigit {

    // Napisz funkcję która dla zadanej liczby całkowitej zwraca jej najmniejszą cyfrę


    public int findSmallestDigit(int number){
        number = Math.abs(number);
        int smallest = number;
        while (number > 0) {
            int digit = number % 10;
            if (digit <= smallest) {
                smallest = digit;
            }
            number = number / 10;
        }
        return smallest;
    }
}
