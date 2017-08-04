package pl.com.bottega.shortestInscription;

import java.util.NoSuchElementException;

public class ShortestInscription {

    //Napisz funkcję, króra dla zadanej tablicy napisów zwraca długość najkrótszego napisu w tablicy.

    public String getShortestInscription(String[] tab){
        if (tab.length < 0)
            throw new NoSuchElementException("pusta tablica");
        String shortest = tab[0];
        for (int i = 1; i < tab.length; i++){
            if (tab[i].length() < shortest.length())
                shortest = tab[i];
        }
        return shortest;
    }
}
