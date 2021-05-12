import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value = PER_CLASS)
public class BaseFuncTest {
    private static final double DELTA = 0.05;

    private Sin sin;
    Ln ln = new Ln();

    @BeforeAll
    public void init() {
        sin = new Sin();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sin_test_data.csv")
    public void sinTest(float x, float expected) {
        double actual = sin.calculate(x);
        assertEquals(expected, actual, DELTA);
        CsvLogger csvLogger = new CsvLogger("sin.csv", -1, 1, 0.1);
        csvLogger.log(sin);
    }

    @Test
    void testLn() {
        assertEquals(0.6931347573322881, ln.calculate(2), DELTA);
        assertEquals(-1.3468559468930204, ln.calculate(0.26), DELTA);
        assertEquals(-1.347, ln.calculate(0.26), DELTA);
        assertEquals(-0.288, ln.calculate(0.75), DELTA);
        assertEquals(0.548, ln.calculate(1.73), DELTA);
        assertEquals(2.345, ln.calculate(10.45), DELTA);
        assertEquals(1.3860012904394805, ln.calculate(4), DELTA);

        CsvLogger csvLogger = new CsvLogger("ln.csv", 2, 4, 0.1);
        csvLogger.log(ln);
    }



    @Test
    public void nanTest() {
        assertThrows(IllegalArgumentException.class,
                () -> sin.calculate(Double.NaN));
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;
        double actual = sin.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = sin.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }
}
