public class Power extends Function {
    private int exponent;
    private Function function;
    public Power (Function function, int exponent) {
        this.function = function;
        this.exponent = exponent;
    }
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
        return "(" + function.toString() + "^" + exponent + ")";
    }

    @Override
    public Function derivative() {
        return new MultiProduct(new Constant(exponent), function.derivative(), new Power(function, exponent - 1));
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        Function powerFunction = this;  // Current Power function
        Root rootFinder = new Root(powerFunction);
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
}
