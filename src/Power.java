public class Power extends Function {
    private int power;
    @Override
    public double valueAt(double x) {
        double ret = 1;
        double value = function.valueAt(x);
        for (int i = 0; i < exponent; i++)
            ret *= value;
        return value;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Function derivative() {
        return null;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    @Override
    public Function taylorPolynomial(int n) {
        return null;
    }
}
