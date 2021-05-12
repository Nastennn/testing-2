import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DependentFuncTest {
        double delta = 0.001;

        Sin mockSin;
        Ln mockLn;
        Log mockLog;
        Cos mockCos;
        Cos cos;
        Csc csc;
        Tan tan;
        Log log;



        @BeforeEach
        public void setUp() {
            mockSin = mock(Sin.class);
            mockCos = mock(Cos.class);
            mockLn = mock(Ln.class);
            mockLog = mock(Log.class);
            // sin
            when(mockSin.calculate(eq(0))).thenReturn(0.0);
            when(mockSin.calculate(eq(PI / 2))).thenReturn(1.0);
            when(mockSin.calculate(eq(PI))).thenReturn(0.0);
            when(mockSin.calculate(eq(3* PI / 2))).thenReturn(-1.0);
            when(mockSin.calculate(eq(2 * PI))).thenReturn(0.0);
            when(mockSin.calculate(eq(PI / 6))).thenReturn(0.5);
            when(mockSin.calculate(eq(PI / 3))).thenReturn(0.866);
            when(mockSin.calculate(eq(-PI / 4))).thenReturn(-0.7071067811865475);
            when(mockSin.calculate(eq(0.77777))).thenReturn(0.7016923346562092);
            when(mockSin.calculate(eq(-0.99995))).thenReturn(-0.8414439686407756);
            when(mockSin.calculate(eq(0.246))).thenReturn(0.24352634067370285);
            when(mockSin.calculate(eq(0.3777))).thenReturn(0.3687835615501242);



            //cos
            when(mockCos.calculate(eq(1))).thenReturn(1.0);
            when(mockCos.calculate(eq(PI / 3))).thenReturn(0.5);
            when(mockCos.calculate(eq(PI / 6))).thenReturn(0.8660254037844387);
            when(mockCos.calculate(eq(PI))).thenReturn(-1.0);
            when(mockCos.calculate(eq(-PI / 8))).thenReturn(0.9238795325112867);
            when(mockCos.calculate(eq(-PI / 4))).thenReturn(0.7071067811865476);
            when(mockCos.calculate(eq(0.77777))).thenReturn(0.7124800821670165);
            when(mockCos.calculate(eq(-0.99995))).thenReturn(0.5403443787419847);
            when(mockCos.calculate(eq(0.246))).thenReturn(0.9698942836196508);
            when(mockCos.calculate(eq(0.3777))).thenReturn(0.9295152955871171);

            cos = new Cos(mockSin);
            csc = new Csc(mockSin);
            tan = new Tan(mockSin, mockCos);

            when(mockLn.calculate(eq(2.0))).thenReturn(0.6931347573322881);
            when(mockLn.calculate(eq(4.0))).thenReturn(1.3860012904394805);
            when(mockLn.calculate(eq(0.0))).thenReturn(-8.872264846920087);
            when(mockLn.calculate(eq(0.255))).thenReturn(-1.36623913071725);
            when(mockLn.calculate(eq(8.0))).thenReturn(2.078344410930892);
            when(mockLn.calculate(eq(17.0))).thenReturn(2.830394243832383);
            when(mockLn.calculate(eq(3.0))).thenReturn(1.0984995039682537);
            when(mockLn.calculate(eq(5.0))).thenReturn(1.6089342949001875);
            when(mockLn.calculate(eq(10.0))).thenReturn(2.3011729576085216);
            when(mockLn.calculate(eq(9.0))).thenReturn(2.1972245);

            log = new Log(mockLn);
        }


        @Test
        public void testCos() {
            assertEquals(1, cos.calculate(0), delta);
            assertEquals(0, cos.calculate(PI / 2), delta);
            assertEquals(-1, cos.calculate(PI), delta);
            assertEquals(0, cos.calculate(3 * PI / 2), delta);
            assertEquals(1, cos.calculate(2 * PI), delta);
            assertEquals(0.866, cos.calculate(PI / 6), delta);
            assertEquals(0.5, cos.calculate(PI / 3), delta);
            CsvLogger csvLogger = new CsvLogger("cos.csv", -1, 1, 0.1);
            csvLogger.log(cos);
        }

        @Test
        void testCsc() {
            assertEquals(-1, csc.calculate(3 * PI / 2), delta);
            assertEquals(1, csc.calculate(PI / 2), delta);
            assertEquals(2, csc.calculate(PI / 6), delta);
            assertEquals(1.1547, csc.calculate(PI / 3), delta);
            assertEquals(-1.4142135623730951, csc.calculate(-PI / 4), delta);
            assertEquals(1.425126014081293, csc.calculate(0.77777), delta);
            assertEquals(-1.188433261474733, csc.calculate(-0.99995), delta);
            assertEquals(4.106331977204406, csc.calculate(0.246), delta);
            assertEquals(2.7116176106024246, csc.calculate(0.3777), delta);
            CsvLogger csvLogger = new CsvLogger("csc.csv", -1, 1, 0.1);
            csvLogger.log(csc);
        }

        @Test
        void testTan() {
            assertEquals(1.7320508075688767, tan.calculate(PI / 3), delta);
            assertEquals(0.5773502691896258, tan.calculate(PI / 6), delta);
            assertEquals(-1.0, tan.calculate(-PI / 4), delta);
            assertEquals(0.9848588784713864, tan.calculate(0.77777), delta);
            assertEquals(-1.55723646205, tan.calculate(-0.99995), delta);
            assertEquals(0.2510854479571332, tan.calculate(0.246), delta);
            assertEquals(0.3967482442741155, tan.calculate(0.3777), delta);
            CsvLogger csvLogger = new CsvLogger("tan.csv", -1, 1, 0.1);
            csvLogger.log(tan);
        }


    @Test
    void testLog2() {
        assertEquals(2, log.log(4, 2), delta);
        assertEquals(-12.800201913214305, log.log(0, 2), delta);
        assertEquals(-1.971101746470746, log.log(0.255, 2), delta);
        assertEquals(2.9984709162904317, log.log(8, 2), delta);
        assertEquals(4.083468927061025, log.log(17, 2), delta);
        assertEquals(1.584828191557034, log.log(3, 2), delta);
        assertEquals(2.3212431318443696, log.log(5, 2), delta);
        assertEquals(3.3199503174032023, log.log(10, 2), delta);
        }

    @Test
    void testLog3(){
        assertEquals(0.6309832228675449, log.log(2, 3), delta);
        assertEquals(1.261722272456789, log.log(4, 3), delta);
        assertEquals(-8.076712656555276, log.log(0, 3), delta);
        assertEquals(-1.2437321325879578, log.log(0.255, 3), delta);
        assertEquals(1.891984842435537, log.log(8, 3), delta);
        assertEquals(2.5766003840764413, log.log(17, 3), delta);
        assertEquals(1, log.log(3, 3), delta);
        assertEquals(1.4646654723903136, log.log(5, 3), delta);
        assertEquals(2.094832951035201, log.log(10, 3), delta);
        assertEquals(2, log.log(9, 3), delta);
    }

    @Test
    void testLog5(){
        assertEquals(0.4308036440824874, log.log(2, 5), delta);
        assertEquals(0.8614405789177756, log.log(4, 5), delta);
        assertEquals(-5.514373629204349, log.log(0, 5), delta);
        assertEquals(-0.8491578152369526, log.log(0.255, 5), delta);
        assertEquals(1.2917521974132729, log.log(8, 5), delta);
        assertEquals(1.7591732942754945, log.log(17, 5), delta);
        assertEquals(0.6827497601674285, log.log(3, 5), delta);
        assertEquals(1, log.log(5, 5), delta);
        assertEquals(1.43024669491011, log.log(10, 5), delta);
        assertEquals(1.364854872891428, log.log(9, 5), delta);
    }

    }

