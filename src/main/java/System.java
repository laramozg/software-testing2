import java.io.PrintStream;

public class System {
    private final Functions functions;

    public System(Functions functions) {
        this.functions = functions;
    }

    public double calculate(double x) {
        if (x <= 0)
            return trigonometric(x);
        else
            return logarithmic(x);
    }

    public double trigonometric(double x) {
        return Math.pow(functions.sec(x)*functions.cos(x), 2) - (functions.cos(x)/(functions.csc(x)/ functions.cot(x)));
    }

    public double logarithmic(double x) {
        return ((((functions.ln(x)+ functions.log10(x))* functions.ln(x)* functions.log10(x))* functions.log2(x)/ functions.log10(x)) * functions.log3(x)* functions.ln(x)) + functions.log2(x);
    }
}
