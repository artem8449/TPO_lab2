package test;

import main.Decomposers.LogDecomposer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogDecompositionTest {
    final double DELTA = 0.001;
    final double EPS = 0.0001;
    final LogDecomposer logDecomposer = new LogDecomposer();

    @Test
    void testZero(){
        assertEquals(Double.NaN, logDecomposer.calculate(0., DELTA));
    }

    @Test
    void testNearZero(){
        assertEquals(Math.log(0.08), logDecomposer.calculate(0.08, EPS), DELTA);
    }

    @Test
    void testHalf(){
        assertEquals(Math.log(0.5), logDecomposer.calculate(0.5, EPS), DELTA);
    }

    @Test
    void testOne(){
        assertEquals(Math.log(1), logDecomposer.calculate(1., EPS), DELTA);
    }

    @Test
    void testTen(){
        assertEquals(Math.log(10), logDecomposer.calculate(10., EPS), DELTA);
    }

}
