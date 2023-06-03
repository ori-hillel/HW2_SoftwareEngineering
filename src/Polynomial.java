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
        double[] ret = coefficients.clone();
        for (int i = 0; i < coefficients.length; i++) {
            if (i == coefficients.length - 1)
                ret[i] = 0;
            ret[i] = coefficients[i+1]*(i+1);
        }
        return new Polynomial(ret);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        Function polynomial = this;  // Current polynomial function
        Root rootFinder = new Root(polynomial);

        return rootFinder.findRootByBisection(a, b, epsilon);
    }
    @Override
    public double bisectionMethod(double a, double b) {
        Function constFunction = this;
        Root rootFinder= new Root(constFunction);
        return rootFinder.findRootByBisection(a,b);
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    @Override
    public Function taylorPolynomial(int n) {
        return null;
    }

    private double factorial(double x) {
        double result = 1.0;
        for (int i = 2; i <=x; i++)
            result *= i;
        return result;
    }
}
