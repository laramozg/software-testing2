public class Functions {
    private final InitialFunctions initialFunctions  = new InitialFunctions();


    public double sin(double x) {
        return initialFunctions.sin(x);
    }

    public double cos(double x) {
        return sin(x + Math.PI / 2);
    }

    public double cot(double x) {
        return cos(x) / sin(x);
    }

    public double sec(double x) {
        return 1 / cos(x);
    }

    public double csc(double x) {
        return 1 / sin(x);
    }

    public double ln(double x) {
        return initialFunctions.ln(x);
    }

    public double log2(double x) {
        return ln(x) / Math.log(2);
    }

    public double log3(double x) {
        return ln(x) / Math.log(3);
    }

    public double log10(double x) {
        return ln(x) / Math.log(10);
    }
}
