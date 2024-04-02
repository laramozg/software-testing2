import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class InitialFunctionTest {
    InitialFunctions initialFunctions;

    @BeforeEach
    void init() {
        initialFunctions = new InitialFunctions();
    }

    @ParameterizedTest
    @ValueSource(doubles = { Math.PI / 2, Math.PI , 0.02, 4.2})
    void testPositiveLogarithm(double x) {
        assertAll(
                () -> assertEquals(Math.log(x), initialFunctions.ln(x), 0.001)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = { -Math.PI / 2, 0 , -0.02, -4.2})
    void testNegativeLogarithm(double x) {
        assertAll(
                () -> assertEquals(Double.NaN, initialFunctions.ln(x)));
    }

    @ParameterizedTest
    @ValueSource(doubles = { -Math.PI / 2, 0 , -0.02, 4.2, 2})
    void testSin(double x) {
        assertAll(
                () -> assertEquals(Math.sin(x), initialFunctions.sin(x), 0.001)
        );
    }

    @Test
    void testSinNegInfinity() {
        assertAll(
                () -> assertEquals(Double.NaN, initialFunctions.sin(Double.NEGATIVE_INFINITY), 0.001)
        );
    }


}
