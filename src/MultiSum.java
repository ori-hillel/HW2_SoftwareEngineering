public class MultiSum extends Function {
    private Function[] functions;
    public MultiSum(Function function, Function ... functions) {}

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
        Function multiSumFunction = this;  // Current MultiSum function
        Root rootFinder = new Root(multiSumFunction);

        return rootFinder.findRoot(a, b, epsilon);
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
