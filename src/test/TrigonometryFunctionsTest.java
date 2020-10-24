package test;

import main.Decomposers.SinDecomposer;
import main.Functions.TrigonometryFunctions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static java.lang.Math.*;

public class TrigonometryFunctionsTest {
    static final double EPSILON = 0.00001;
    static final double DELTA = 0.001;
    static SinDecomposer sinMock;
    static TrigonometryFunctions trigonometryFunctions;

    @BeforeAll
    static void setUp() {
        sinMock = mock(SinDecomposer.class);
        when(sinMock.calculate(0.0, EPSILON)).thenReturn(0.0);
        when(sinMock.calculate(PI / 6, EPSILON)).thenReturn(0.5);
        when(sinMock.calculate(PI / 4, EPSILON)).thenReturn(sqrt(2) / 2);
        when(sinMock.calculate(PI / 3, EPSILON)).thenReturn(sqrt(3) / 2);
        when(sinMock.calculate(PI / 2, EPSILON)).thenReturn(1.0);
        when(sinMock.calculate(PI, EPSILON)).thenReturn(0.0);
        when(sinMock.calculate(PI * 5 / 4, EPSILON)).thenReturn(-sqrt(2) / 2);
        when(sinMock.calculate(PI * 3 / 2, EPSILON)).thenReturn(-1.0);
        when(sinMock.calculate(PI / 4 + PI/2, EPSILON)).thenReturn(1/sqrt(2));
        when(sinMock.calculate(PI * 7 / 4, EPSILON)).thenReturn(-sqrt(2) / 2);

        trigonometryFunctions = new TrigonometryFunctions(sinMock);
    }

    @ParameterizedTest
    @ValueSource(doubles =  {0, PI/2, PI/4, PI*3/4, PI, PI*5/4})
    void cosTest(double x) {
        assertEquals(Math.cos(x), trigonometryFunctions.cos(x, EPSILON), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles =  {0, PI/4, PI*3/4, PI, PI*5/4})
    void secValidValuesTest(double x) {
        assertEquals(1 / Math.cos(x), trigonometryFunctions.sec(x, EPSILON), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = { PI/2, PI * 3/2 })
    void secInvalidTest(double x) {
        assertEquals(Double.NaN, trigonometryFunctions.sec(x, EPSILON), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles =  {0, PI/4, PI*3/4, PI, PI*5/4})
    void tanValidValuesTest(double x) {
        assertEquals(Math.sin(x) / Math.cos(x), trigonometryFunctions.tan(x, EPSILON), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {PI/2, PI * 3/2 })
    void tanInvalidTest(double x) {
        assertEquals(Double.NaN, trigonometryFunctions.tan(x, EPSILON), DELTA);
    }





}
