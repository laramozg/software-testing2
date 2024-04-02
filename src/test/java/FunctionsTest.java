import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FunctionsTest {
    private Functions functions = Mockito.spy(new Functions());

    @BeforeEach
    void init() {
        Mockito.when(functions.sin(-3.141592653589793))
                .thenReturn(Double.NaN);

        Mockito.when(functions.cos(-3.141592653589793))
                .thenReturn(Double.NaN);

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/cot.csv")
    void cotTest(double x, double expected) {
        assertEquals(expected, functions.cot(x), 0.01);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/sec.csv")
    void secTest(double x, double expected) {
        assertEquals(expected, functions.sec(x), 0.001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csc.csv")
    void cscTest(double x, double expected) {
        assertEquals(expected, functions.csc(x), 0.001);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/log10.csv")
    void log10Test(double x, double expected) {
        assertEquals(expected, functions.log10(x), 0.001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log3.csv")
    void log3Test(double x, double expected) {
        if (x == 0.00840734641020724) Mockito.doReturn(-10.0).when(functions).ln(x);
        assertEquals(expected, functions.log3(x), 0.001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log2.csv")
    void log2Test(double x, double expected) {
        assertEquals(expected, functions.log2(x), 0.001);
    }

}
