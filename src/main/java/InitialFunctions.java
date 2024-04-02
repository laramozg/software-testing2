public class InitialFunctions {
    private final double PRECISION = 1E-12;

    public double sin(double x) {
        if (x == Double.NEGATIVE_INFINITY)
            return Double.NaN;
        double x1 = x % (2 * Math.PI);
        if (Math.abs(Math.abs(x1) - Math.PI) < PRECISION || Math.abs(Math.abs(x1) - 2 * Math.PI) < PRECISION || Math.abs(Math.abs(x1) - 0.0) < PRECISION) {
            return 0.0;
        }
        return sin(x1, x1, 1, 0.0);
    }

    private double sin(double x, double cur, int n, double res) {
        if (Math.abs(cur) < PRECISION) return res;
        return sin(x, cur * (-x * x / (2.0 * n * (2.0 * n + 1.0))), n + 1, res + cur);
    }

    public double ln(double x) {
        if (x <= 0)
            return Double.NaN;
        double x1 = (x - 1) / (x + 1);
        double cur = x1;
        double res = 0.0;
        int n = 3;
        while (Math.abs(2 * cur) > PRECISION / 10) {
            res += 2 * cur;
            cur *= x1 * x1 / n * (n - 2);
            n += 2;
        }
        return res;
    }
}
