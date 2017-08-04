package pl.com.bottega.palindrom;

public class Palindrom {

    // Napisz funkcję, która dla zadanego napisu zwraca true jeśli jest on palindromem,
    // w przeciwnym razie false. Palindrom to napis, który od końca czyta się tak samo jak od początku.
    // Przykłady palindromów: ala, zaraz, abba, 122221


    public static boolean ifPalindrom(String text) {
        text = text.trim();
        if (text.length() % 2 == 0) {
            for (int i = 0; i < text.length() / 2; i++) {
                if (Character.compare(text.charAt(i), text.charAt(text.length() - i - 1)) == 0)
                    continue;
                return false;
            }
        } else
            for (int i = 0; i < (text.length() - 1) / 2; i++) {
                if (Character.compare(text.charAt(i), text.charAt(text.length() - i - 1)) == 0)
                    continue;
                return false;
            }
        return true;
    }
}

