public class Polynomial extends Function {
    private double[] coefficients;
    public Polynomial(double... coefficients) {

    }

    @Override
    public double valueAt(double x) {
        return 0;
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
        Function polynomial = this;  // Current polynomial function
        Root rootFinder = new Root(polynomial);

        return rootFinder.findRootByBisection(a, b, epsilon);
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
