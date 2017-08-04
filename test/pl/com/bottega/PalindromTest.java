package pl.com.bottega;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.com.bottega.palindrom.Palindrom;

public class PalindromTest {

    @Test
    void canRecognizePalindrom(){
        Palindrom palindrom = new Palindrom();
        boolean test = palindrom.ifPalindrom("1gh  hg1");
        assertTrue(test);
    }
    @Test
    void canRecognizeThanNonPalindrom(){
        Palindrom palindrom = new Palindrom();
        boolean test = palindrom.ifPalindrom("1gh  hg1W");
        assertFalse(test);
    }
}
