import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SystemTest {
        double delta = 0.001;

        Ln mockLn;
        Log mockLog;
        Tan mockTan;
        Csc mockCsc;
        System sys;



        @BeforeEach
        public void setUp() {
            mockTan = mock(Tan.class);
            mockCsc = mock(Csc.class);
            mockLog = mock(Log.class);
            mockLn = mock(Ln.class);

            // x = -1
            when(mockCsc.calculate(eq(-1.0))).thenReturn(-1.188395105778);
            when(mockTan.calculate(eq(-1.0))).thenReturn(-1.55740772465490223);


            //x = -15

            when(mockCsc.calculate(eq(-15.0))).thenReturn(-3.8637033051562737);
            when(mockTan.calculate(eq(-15.0))).thenReturn(-0.2679491924311227);

            //x = -14

            when(mockCsc.calculate(eq(-14.0))).thenReturn(-4.133565494438749);
            when(mockTan.calculate(eq(-14.0))).thenReturn(-0.24932800284318068);
            //x = -13

            when(mockCsc.calculate(eq(-13.0))).thenReturn(-4.445411482585801);
            when(mockTan.calculate(eq(-13.0))).thenReturn(-0.23086819112556312);
            //x = -12

            when(mockCsc.calculate(eq(-12.0))).thenReturn(-4.809734344744131);
            when(mockTan.calculate(eq(-12.0))).thenReturn(-0.21255656167002213);
            //x = -11

            when(mockCsc.calculate(eq(-11.0))).thenReturn(-5.240843064167849);
            when(mockTan.calculate(eq(-11.0))).thenReturn(-0.19438030913771848);
            //x = -10

            when(mockCsc.calculate(eq(-10.0))).thenReturn(-5.758770483143634);
            when(mockTan.calculate(eq(-10.0))).thenReturn(-0.17632698070846498);


            //x = -9

            when(mockCsc.calculate(eq(-9.0))).thenReturn(-6.392453221499662);
            when(mockTan.calculate(eq(-9.0))).thenReturn(-0.15838444032453627);

            //x = -8

            when(mockCsc.calculate(eq(-8.0))).thenReturn(-7.185296534327719);
            when(mockTan.calculate(eq(-8.0))).thenReturn(-0.14054083470239145);
            //x = -7

            when(mockCsc.calculate(eq(-7.0))).thenReturn(-8.205509048125078);
            when(mockTan.calculate(eq(-7.0))).thenReturn(-0.1227845609029);
            //x = -6

            when(mockCsc.calculate(eq(-6.0))).thenReturn(-9.566772233505626);
            when(mockTan.calculate(eq(-6.0))).thenReturn(-0.10510423526567647);
            //x = -5

            when(mockCsc.calculate(eq(-5.0))).thenReturn(-11.47371324567);
            when(mockTan.calculate(eq(-5.0))).thenReturn(-0.08748866352592401);
            //x = -4

            when(mockCsc.calculate(eq(-4.0))).thenReturn(1.3213487088109024);
            when(mockTan.calculate(eq(-4.0))).thenReturn(-1.1578212823495775);
            //x = -3

            when(mockCsc.calculate(eq(-3.0))).thenReturn(-7.086167395737187);
            when(mockTan.calculate(eq(-3.0))).thenReturn(0.1425465430742778);
            //x = -2

            when(mockCsc.calculate(eq(-2.0))).thenReturn(-1.0997501702946164);
            when(mockTan.calculate(eq(-2.0))).thenReturn(2.185039863261519);

            // x = 0.3
            when(mockLog.log(eq(0.3), eq(3))).thenReturn(-1.09590);
            when(mockLog.log(eq(0.3), eq(5))).thenReturn(-0.748070);
            when(mockLog.log(eq(0.3), eq(2))).thenReturn(-1.73697);
            when(mockLn.calculate(eq(0.3))).thenReturn(-1.2039728043259361);

            // x = 0.6
            when(mockLog.log(eq(0.6), eq(3))).thenReturn(-0.464974);
            when(mockLog.log(eq(0.6), eq(5))).thenReturn(-0.317394);
            when(mockLog.log(eq(0.6), eq(2))).thenReturn(-0.736966);
            when(mockLn.calculate(eq(0.6))).thenReturn(-0.5108256237659907);

            // x = 0.9
            when(mockLog.log(eq(0.9), eq(3))).thenReturn(-0.0959033);
            when(mockLog.log(eq(0.9), eq(5))).thenReturn(-0.0654642);
            when(mockLog.log(eq(0.9), eq(2))).thenReturn(-0.152003);
            when(mockLn.calculate(eq(0.9))).thenReturn(-0.10536051565782628);

            // x = 1.2
            when(mockLog.log(eq(1.2), eq(3))).thenReturn(0.165956);
            when(mockLog.log(eq(1.2), eq(5))).thenReturn(0.113283);
            when(mockLog.log(eq(1.2), eq(2))).thenReturn(0.263034);
            when(mockLn.calculate(eq(1.2))).thenReturn(0.1823215567939546);


            // x = 1.5
            when(mockLog.log(eq(1.5), eq(3))).thenReturn(0.369070);
            when(mockLog.log(eq(1.5), eq(5))).thenReturn(0.251930);
            when(mockLog.log(eq(1.5), eq(2))).thenReturn(0.584963);
            when(mockLn.calculate(eq(1.5))).thenReturn(0.4054651081081644);
            // x = 1.8
            when(mockLog.log(eq(1.8), eq(3))).thenReturn(0.535026);
            when(mockLog.log(eq(1.8), eq(5))).thenReturn(0.365212);
            when(mockLog.log(eq(1.8), eq(2))).thenReturn(0.847997);
            when(mockLn.calculate(eq(1.8))).thenReturn(0.5877866649021191);
            // x = 2.1
            when(mockLog.log(eq(2.1), eq(3))).thenReturn(0.675340);
            when(mockLog.log(eq(2.1), eq(5))).thenReturn(0.460992);
            when(mockLog.log(eq(2.1), eq(2))).thenReturn(1.07039);
            when(mockLn.calculate(eq(2.1))).thenReturn(0.7419373447293773);
            // x = 2.4
            when(mockLog.log(eq(2.4), eq(3))).thenReturn(0.796886);
            when(mockLog.log(eq(2.4), eq(5))).thenReturn(0.543959);
            when(mockLog.log(eq(2.4), eq(2))).thenReturn(1.26303);
            when(mockLn.calculate(eq(2.4))).thenReturn(0.8754687373539);
            // x = 2.7
            when(mockLog.log(eq(2.7), eq(3))).thenReturn(0.904097);
            when(mockLog.log(eq(2.7), eq(5))).thenReturn(0.617142);
            when(mockLog.log(eq(2.7), eq(2))).thenReturn(1.43296);
            when(mockLn.calculate(eq(2.7))).thenReturn(0.9932517730102834);

            // x = 3
            when(mockLog.log(eq(3.0), eq(3))).thenReturn(1.0);
            when(mockLog.log(eq(3.0), eq(5))).thenReturn(0.682606);
            when(mockLog.log(eq(3.0), eq(2))).thenReturn(1.58496);
            when(mockLn.calculate(eq(3.0))).thenReturn(1.0986122886681098);
            sys = new System(mockTan, mockCsc, mockLn, mockLog);
        }


        @Test
        public void testSystemLessThanZero() {
            assertEquals(27.474371152229028639497008, sys.calculate(-1), delta);
            assertEquals(-3.977749405852671076765, sys.calculate(-15), delta);
            assertEquals(-4.25889878596377109195567, sys.calculate(-14), delta);
            assertEquals(-4.577837252290931845066765, sys.calculate(-13), delta);
            assertEquals(-4.945463966386783886133, sys.calculate(-12), delta);
            assertEquals(-5.37646810789179954615, sys.calculate(-11), delta);
            assertEquals(-5.8912397186514071, sys.calculate(-10), delta);
            assertEquals(-6.51905227289514657, sys.calculate(-9), delta);
            assertEquals(-7.303629976313234012239, sys.calculate(-8), delta);
            assertEquals(-8.3134847611682355525, sys.calculate(-7), delta);
            assertEquals(-9.662587860731168143971, sys.calculate(-6), delta);
            assertEquals(-11.5558446170030194, sys.calculate(-5), delta);
            assertEquals(12.58046711564295409, sys.calculate(-4), delta);
            assertEquals(-6.9667926678395655, sys.calculate(-3), delta);
            assertEquals(-82.372730978678351648132, sys.calculate(-2), delta);
            CsvLogger csvLogger = new CsvLogger("system_neg.csv", -15, 0, 1);
            csvLogger.log(sys);
        }

        @Test
        public void testSystemMoreThanZero() {
            assertEquals(-8.10958, sys.calculate(0.3), delta);
            assertEquals(-15.5073, sys.calculate(0.6), delta);
            assertEquals(-364.214, sys.calculate(0.9), delta);
            assertEquals(-121.629, sys.calculate(1.2), delta);
            assertEquals(-24.59, sys.calculate(1.5), delta);
            assertEquals(-11.6672, sys.calculate(1.8), delta);
            assertEquals(-7.16521, sys.calculate(2.1), delta);
            assertEquals(-4.70321, sys.calculate(2.4), delta);
            assertEquals(-2.7145, sys.calculate(2.7), delta);
            assertEquals(-0.547385, sys.calculate(3.0), delta);
            CsvLogger csvLogger = new CsvLogger("system_pos.csv", 0.3, 3.1, 0.3  );
            csvLogger.log(sys);
        }

    }

