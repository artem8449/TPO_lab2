package test;

import main.Decomposers.SinDecomposer;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinDecompositionTest {
    final double DELTA = 0.001;
    final double EPS = 0.0001;
    SinDecomposer sinDecomposer = new SinDecomposer();

    @Test
    void testMinusPI(){
        assertEquals(Math.sin(-Math.PI), sinDecomposer.calculate(-Math.PI, EPS), DELTA);
    }

    @Test
    void testMinusHalfPI(){
        assertEquals(Math.sin(-Math.PI / 2), sinDecomposer.calculate(-Math.PI / 2, EPS), DELTA);
    }

    @Test
    void testMinusOne(){
        assertEquals(Math.sin(-1), sinDecomposer.calculate(-1., EPS), DELTA);
    }

    @Test
    void testZero(){
        assertEquals(Math.sin(0), sinDecomposer.calculate(0., EPS), DELTA);
    }

    @Test
    void testOne(){
        assertEquals(Math.sin(1), sinDecomposer.calculate(1., EPS), DELTA);
    }

    @Test
    void testHalfPI(){
        assertEquals(Math.sin(Math.PI / 2), sinDecomposer.calculate(Math.PI / 2, EPS), DELTA);
    }

    @Test
    void testPI(){
        assertEquals(Math.sin(Math.PI), sinDecomposer.calculate(Math.PI, EPS), DELTA);
    }

    @Test
    void testPiBySix(){
        assertEquals(0.5, sinDecomposer.calculate(PI / 6, EPS), DELTA);
    }


}
