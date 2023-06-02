public class Polynomial extends Function {
    private double[] coefficients;
    public Polynomial(double... coefficients) {

    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        Function base;
        Function baseToExponent;
        Function coefficient;
        Function func;
        for (int exp = 0; exp < coefficients.length; exp++) {
            base = new Constant(exp);
            baseToExponent = new Power(base, exp);
            coefficient = new Constant(coefficients[exp]);
            func = new Product(baseToExponent, coefficient);
            sum += func.valueAt(x);
        }
        return sum;
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
