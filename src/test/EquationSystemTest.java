package test;

import com.sun.xml.internal.messaging.saaj.util.LogDomainConstants;
//import main.Decomposers.LogDecomposer;
import main.EquationSystem;
import main.Functions.LogNFunctions;

import main.Functions.TrigonometryFunctions;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import static java.lang.Math.log;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import static java.lang.Math.*;

public class EquationSystemTest {
    static final double EPSILON = 0.0001;
    static final double DELTA = 0.001;

    static TrigonometryFunctions trigonometryFuncMock;
    static LogNFunctions logNFuncMock;
    static EquationSystem equationSystem;

 //   static LogDecomposer logDecomposer = new LogDecomposer();
    @BeforeAll
    static void setUp() {
        trigonometryFuncMock = mock(TrigonometryFunctions.class);
        logNFuncMock = mock(LogNFunctions.class);

        when(trigonometryFuncMock.tan(-PI/4, EPSILON)).thenReturn(-1.);
        when(trigonometryFuncMock.sec(-PI/4, EPSILON)).thenReturn(Math.sqrt(2));
        when(trigonometryFuncMock.cos(-PI/4, EPSILON)).thenReturn(1/Math.sqrt(2));

        when(logNFuncMock.log(1.1,EPSILON, E)).thenReturn(log(1.1));
        when(logNFuncMock.log(1.1,EPSILON, 2)).thenReturn(0.137504);
        when(logNFuncMock.log(1.1,EPSILON, 3)).thenReturn(0.08675);
        when(logNFuncMock.log(1.1,EPSILON, 5)).thenReturn(0.0592195);
        when(logNFuncMock.log(1.1,EPSILON, 10)).thenReturn(0.04139);

        equationSystem = new EquationSystem(trigonometryFuncMock, logNFuncMock);
    }

    @Test
    void funcLogTest() {
        assertEquals(0.0002279, equationSystem.func1(1.1, EPSILON), DELTA);
    }


    @Test
    void funcTrigonometryTest() {
        assertEquals(0.85355, equationSystem.func2(-PI / 4, EPSILON), DELTA);
    }

    @Test
    void equationSystemMoreZeroTest() {
        assertEquals(0.0002279, equationSystem.calculate(1.1, EPSILON), DELTA);
    }

    @Test
    void equationSystemLessZeroTest() {
        assertEquals(0.85355, equationSystem.calculate(-PI / 4, EPSILON), DELTA);
    }



}
