package pl.com.bottega.charCounter;


import java.util.Scanner;

public class Counter {

    private static int upper;
    private static int lower;

    public static void main(String[] args) {

        // Napisz funkcję, która dla zadanego parametru typu String zwraca obiekt
        // zawierający informacje o ilości małych i wielkich liter w zadanym napisie.
        // Napisz program konsolowy testujący tę funkcję.

        while (true){
            System.out.println("podaj tekst:");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            count(text);
            System.out.println("duże: "+upper);
            System.out.println("małe: "+lower);
        }
    }

    static void count(String s){
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if (Character.isUpperCase(letter)){
                upper++;
            }else if (Character.isLowerCase(letter)){
                lower++;
            }
        }
    }
}
