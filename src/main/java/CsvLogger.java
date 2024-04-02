import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Function;


public class CsvLogger {

    private static final double step = 0.05;
    private static final double lowValue = -Math.PI;
    private static final double highValue = Math.PI;


    public static void createCsv(Function<Double, Double> function, double step, double lowVal, double highVal, String fileName) throws IOException {
        double x;
        PrintWriter writer = new PrintWriter("src/test/resources/"+fileName+".csv");
        for (int i = 0; i < (highVal - lowVal) / step; ++i) {
            x = lowVal + i * step;
            writer.println(x + ", " + function.apply(x));
        }
        writer.close();

    }

    public static void main(String[] args) throws IOException {
        Functions functions = new Functions();
        System system = new System(functions);
        createCsv(functions::cos, step, lowValue, highValue, "cos");
        createCsv(functions::sin, step, lowValue, highValue, "sin");
        createCsv(functions::cot, step, lowValue, highValue, "cot");
        createCsv(functions::sec, step, lowValue, highValue, "sec");
        createCsv(functions::csc, step, lowValue, highValue, "csc");
//        createCsv(system::trigonometric, step, lowValue, 0, "trigonometric");
        createCsv(functions::ln, step, lowValue, highValue, "ln");
        createCsv(functions::log2, step, lowValue, highValue, "log2");
        createCsv(functions::log3, step, lowValue, highValue, "log3");
        createCsv(functions::log10, step, lowValue, highValue, "log10");
//        createCsv(system::logarithmic, step, lowValue, highValue, "logarithmic");
        createCsv(system::calculate, step, lowValue, highValue, "calculate");
    }

}
