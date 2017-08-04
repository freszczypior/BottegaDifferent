package pl.com.bottega;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.com.bottega.shortestInscription.ShortestInscription;

class ShortestInscriptionTest {

    @Test
    void canGetShortestInscription(){
        String [] tab = {"one", "two", "three", "seven", "h32j2jm2j", "x"};
        ShortestInscription shortestInscription = new ShortestInscription();
        String test = shortestInscription.getShortestInscription(tab);
        assertEquals("x", test);
    }
}
