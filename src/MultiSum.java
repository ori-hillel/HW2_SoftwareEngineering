public class MultiSum extends Function {
    private Function[] functions;

    public Function[] getFunctions() {
        return functions;
    }

    public MultiSum(Function function, Function ... functions) {}

    @Override
    public double valueAt(double x) {
        return 0;
    }

    @Override
    public String toString() {
        String ret = "(";
        for (int i = 0; i < functions.length; i++) {
            if (i == 0)
                ret += functions[i].toString();
            else {
                ret += "+" + functions[i].toString();
            }
        }
        ret += ")";
        return ret;
    }

    @Override
    public Function derivative() {
        Function[] ret = new Function[functions.length];
        for (int i  = 0; i < functions.length; i++)
            ret[i] = functions[i].derivative();
        return new MultiSum(new Constant(0), ret);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        Function multiSumFunction = this;  // Current MultiSum function
        Root rootFinder = new Root(multiSumFunction);

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
