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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemTest {
    private final Functions mock = Mockito.mock(Functions.class);
    System system;

    @BeforeEach
    void init(){
        system = new System(mock);
        mockSinFromFile();
        mockCosFromFile();
        mockCotFromFile();
        mockCscFromFile();
        mockSecFromFile();
        mockLnFromFile();
        mockLog2FromFile();
        mockLog3FromFile();
        mockLog10FromFile();
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

    private void mockSinFromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/sin.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.sin(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockCosFromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/cos.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.cos(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockSecFromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/sec.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.sec(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockCscFromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/csc.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.csc(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockCotFromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/cot.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.cot(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }


    private void mockLnFromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/ln.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.ln(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockLog2FromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/log2.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.log2(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockLog3FromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/log3.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.log3(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }

    private void mockLog10FromFile() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/log10.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(mock.log10(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
            }
        } catch (IOException | CsvException exception) {
            exception.printStackTrace();
        }
    }
}
