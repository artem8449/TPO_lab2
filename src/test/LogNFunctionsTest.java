package test;

import main.Decomposers.LogDecomposer;
import main.Functions.LogNFunctions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.Math.*;

public class LogNFunctionsTest {
    static final double EPSILON = 0.0001;
    static final double DELTA = 0.001;
    static LogDecomposer lnMock;
    static LogNFunctions logFunctions;

    @BeforeAll
    static void setUp() {
        lnMock = mock(LogDecomposer.class);
        when(lnMock.calculate(0., EPSILON)).thenReturn(Double.NaN);
        when(lnMock.calculate(-1., EPSILON)).thenReturn(Double.NaN);
        when(lnMock.calculate(-10., EPSILON)).thenReturn(Double.NaN);
        when(lnMock.calculate(0.2, EPSILON)).thenReturn(logN(0.2, E));
        when(lnMock.calculate(0.2, EPSILON)).thenReturn(logN(0.2, E));
        when(lnMock.calculate(0.5, EPSILON)).thenReturn(logN(0.5, E));
        when(lnMock.calculate(1., EPSILON)).thenReturn(0.0);
        when(lnMock.calculate(2., EPSILON)).thenReturn(logN(2, E));
        when(lnMock.calculate(4., EPSILON)).thenReturn(logN(4, E));
        when(lnMock.calculate(8., EPSILON)).thenReturn(logN(8, E));
        when(lnMock.calculate(72., EPSILON)).thenReturn(logN(72, E));
        when(lnMock.calculate(3., EPSILON)).thenReturn(logN(3, E));
        when(lnMock.calculate(5., EPSILON)).thenReturn(logN(5, E));
        when(lnMock.calculate(10., EPSILON)).thenReturn(logN(10, E));

        logFunctions = new LogNFunctions(lnMock);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.2, 0.5, 1, 2, 4, 8, 72 })
    void log2ValidValuesTest(double x) {
        assertEquals(logN(x, 2), logFunctions.log(x, EPSILON, 2), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -0, -10 })
    void log2InvalidValuesTest(double x) {
        assertEquals(Double.NaN, logFunctions.log(x, EPSILON, 2), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.2, 0.5, 1, 2, 4, 8, 72 })
    void log10ValidValuesTest(double x) {
        assertEquals(log10(x), logFunctions.log(x, EPSILON, 10), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -0, -10 })
    void log10InvalidValuesTest(double x) {
        assertEquals(Double.NaN, logFunctions.log(x, EPSILON, 10), DELTA);
    }

    static double logN(double x, double base) {
        return log(x) / log(base);
    }
}
