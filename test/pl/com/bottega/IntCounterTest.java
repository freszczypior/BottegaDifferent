package pl.com.bottega;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static pl.com.bottega.intCounter.IntCounterApp.countSum;

public class IntCounterTest {

    @Test
    public void canCountNumbers(){
        int sum = countSum(123);
        assertEquals(6, sum);
    }
}
