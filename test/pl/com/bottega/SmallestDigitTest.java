package pl.com.bottega;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.com.bottega.smallestDigit.SmallestDigit;

class SmallestDigitTest {

    @Test
    void canGetSmallestDigit(){
    SmallestDigit smallestDigit = new SmallestDigit();
    int test = smallestDigit.findSmallestDigit(72159);
        assertEquals(1, test);
    }
}
