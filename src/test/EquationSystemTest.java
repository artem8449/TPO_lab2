package test;

import main.EquationSystem;
import main.Functions.LogNFunctions;

import main.Functions.TrigonometryFunctions;
import org.junit.jupiter.api.BeforeAll;
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

    @BeforeAll
    static void setUp() {
        trigonometryFuncMock = mock(TrigonometryFunctions.class);
        logNFuncMock = mock(LogNFunctions.class);

        when(trigonometryFuncMock.tan(-PI/4, EPSILON)).thenReturn(-1.);
        when(trigonometryFuncMock.sec(-PI/4, EPSILON)).thenReturn(Math.sqrt(2));
        when(trigonometryFuncMock.cos(-PI/4, EPSILON)).thenReturn(1/Math.sqrt(2));

        when(trigonometryFuncMock.tan(-3.5, EPSILON)).thenReturn(tan(-3.5));
        when(trigonometryFuncMock.sec(-3.5, EPSILON)).thenReturn(-1.06786);
        when(trigonometryFuncMock.cos(-3.5, EPSILON)).thenReturn(cos(-3.5));

        when(trigonometryFuncMock.tan(-5.8, EPSILON)).thenReturn(tan(-5.8));
        when(trigonometryFuncMock.sec(-5.8, EPSILON)).thenReturn(1.12928);
        when(trigonometryFuncMock.cos(-5.8, EPSILON)).thenReturn(cos(-5.8));

        when(trigonometryFuncMock.tan(-4.2, EPSILON)).thenReturn(tan(-4.2));
        when(trigonometryFuncMock.sec(-4.2, EPSILON)).thenReturn(-2.03973);
        when(trigonometryFuncMock.cos(-4.2, EPSILON)).thenReturn(cos(-4.2));


        when(logNFuncMock.log(1.1,EPSILON, E)).thenReturn(log(1.1));
        when(logNFuncMock.log(1.1,EPSILON, 2)).thenReturn(0.137504);
        when(logNFuncMock.log(1.1,EPSILON, 3)).thenReturn(0.08675);
        when(logNFuncMock.log(1.1,EPSILON, 5)).thenReturn(0.0592195);
        when(logNFuncMock.log(1.1,EPSILON, 10)).thenReturn(0.04139);

        when(logNFuncMock.log(0.5,EPSILON, E)).thenReturn(log(0.5));
        when(logNFuncMock.log(0.5,EPSILON, 2)).thenReturn(-1.);
        when(logNFuncMock.log(0.5,EPSILON, 3)).thenReturn(-0.630930);
        when(logNFuncMock.log(0.5,EPSILON, 5)).thenReturn(-0.430677);
        when(logNFuncMock.log(0.5,EPSILON, 10)).thenReturn(-0.301030);

        when(logNFuncMock.log(2.1,EPSILON, E)).thenReturn(log(2.1));
        when(logNFuncMock.log(2.1,EPSILON, 2)).thenReturn(1.07039);
        when(logNFuncMock.log(2.1,EPSILON, 3)).thenReturn(0.675340);
        when(logNFuncMock.log(2.1,EPSILON, 5)).thenReturn(0.460992);
        when(logNFuncMock.log(2.1,EPSILON, 10)).thenReturn(0.322219);


        equationSystem = new EquationSystem(trigonometryFuncMock, logNFuncMock);
    }

    @Test
    void funcLogAxisCrossingTest() {
        assertEquals(0.0002279, equationSystem.func1(1.1, EPSILON), DELTA);
    }

    @Test
    void funcLogIncreaseLessOneTest() {
        assertEquals(-4.63967, equationSystem.func1(0.5, EPSILON), DELTA);
    }

    @Test
    void funcLogIncreaseMoreOneTest() {
        assertEquals(6.51623, equationSystem.func1(2.1, EPSILON), DELTA);
    }




    @Test
    void funcTrigonometryIncreaseSectionTest(){
        assertEquals(0.85355, equationSystem.func2(-PI/4, EPSILON), DELTA);
        assertEquals(0.24811, equationSystem.func2(-3.5, EPSILON), DELTA);
    }


    @Test
    void funcTrigonometryDecreaseSectionTest() {
        assertEquals(2.03398, equationSystem.func2(-5.8, EPSILON), DELTA);
        assertEquals(-0.04041, equationSystem.func2(-4.2, EPSILON), DELTA);
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
