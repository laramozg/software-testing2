import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemTest {
    private final Functions mock = Mockito.mock(Functions.class);
    System system;

    @BeforeEach
    void init(){
        system = new System(mock);
        mockFromFile(mock::cos, "src/test/resources/cos.csv");
        mockFromFile(mock::sin, "src/test/resources/sin.csv");
        mockFromFile(mock::cot, "src/test/resources/cot.csv");
        mockFromFile(mock::sec, "src/test/resources/sec.csv");
        mockFromFile(mock::csc, "src/test/resources/csc.csv");
        mockFromFile(mock::ln, "src/test/resources/ln.csv");
        mockFromFile(mock::log2, "src/test/resources/log2.csv");
        mockFromFile(mock::log3, "src/test/resources/log3.csv");
        mockFromFile(mock::log10, "src/test/resources/log10.csv");

    }

    @ParameterizedTest
    @ValueSource(doubles = { -Math.PI , -Math.PI/2 , 0, 23})
    void testTrigNan(double x){
        assertAll(
                () -> assertEquals(Double.NaN, system.calculate(x), 0.001)
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculate.csv")
    void testSystem(double x, double expected){
        assertEquals(expected, system.calculate(x), 0.001);
    }

    private void mockFromFile(Function<Double, Double> function, String fileName) {
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(function.apply(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }


}
