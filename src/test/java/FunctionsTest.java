import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FunctionsTest {
    private Functions functions = Mockito.spy(new Functions());

    @Test
    void cosst() {
        Mockito.doReturn(0.0).when(functions).sin(0);
        Mockito.doReturn(0.0).when(functions).sin(Math.PI);
        Mockito.doReturn(1.0).when(functions).sin(Math.PI / 2);
        Mockito.doReturn(-1.0).when(functions).sin(3 * Math.PI / 2);

        assertEquals(0, functions.cos(Math.PI / 2), 0.001);
        assertEquals(0, functions.cos(3 * Math.PI / 2), 0.001);
        assertEquals(1, functions.cos(0), 0.001);
        assertEquals(-1, functions.cos(Math.PI), 0.001);
    }
    @Test
    void tanTest() {
        double x = -4.91;
        Mockito.doReturn(0.00538).when(functions).sin(x);
        Mockito.doReturn(0.196327).when(functions).cos(x);
        assertEquals(
                36.49201, functions.cot(x), 0.001);
    }


    @BeforeEach
    void init() {
        sinMock();
        cosMock();
    }

    private void sinMock() {
        Mockito.when(functions.sin(10))
                .thenReturn(0.5);

        Mockito.when(functions.sin(0))
                .thenReturn(0.0);

    }

    private void cosMock() {
        Mockito.when(functions.cos(10))
                .thenReturn(-0.8);

        Mockito.when(functions.sin(0))
                .thenReturn(1.0);
    }



    @Test
    void cotTest() {
        assertEquals(-1.6, functions.cot(10), 0.01);
    }


    @Test
    void secTest() {
        double x = -5.0;
        assertEquals(3.52535, functions.sec(x), 0.001);
    }

    @Test
    void cscTest() {
        double x = 45.0;
        Mockito.doReturn(0.850904).when(functions).sin(x);
        assertEquals(1.17522, functions.csc(x), 0.001);
    }

//    @Test
//    void logTest() {
//        int base = 8;
//        double x = 56.0;
//        Mockito.doReturn(4.02535).when(functions).ln(x);
//        Mockito.doReturn(2.07944).when(functions).ln(base);
//        assertEquals(1.93578, functions.log(x, base), 0.001);
//    }

    @Test
    void cosTest() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/cos.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                Mockito.when(functions.cos(Double.parseDouble(record[0])))
                        .thenReturn(Double.parseDouble(record[1]));
                assertEquals(0, functions.cos(Math.PI / 2), 0.001);
                //  when(tf.checkAndCalculate(x, TrigIntegrationTest.eps)).thenReturn(y);
            }
        } catch (IOException | CsvException e) {

        }

        Mockito.doReturn(0.0).when(functions).sin(0);
        Mockito.doReturn(0.0).when(functions).sin(Math.PI);
        Mockito.doReturn(1.0).when(functions).sin(Math.PI / 2);
        Mockito.doReturn(-1.0).when(functions).sin(3 * Math.PI / 2);

//        assertEquals(0, functions.cos(Math.PI / 2), 0.001);
//        assertEquals(0, functions.cos(3 * Math.PI / 2), 0.001);
//        assertEquals(1, functions.cos(0), 0.001);
//        assertEquals(-1, functions.cos(Math.PI), 0.001);
    }


}
