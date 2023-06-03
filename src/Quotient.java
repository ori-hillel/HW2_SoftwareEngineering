public class Quotient extends Function {
Function function;
    public Quotient(Function function) {

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
        Function quotientFunction = this;
        Root rootFinder= new Root(quotientFunction);
        return rootFinder.findRootByBisection(a,b,epsilon);
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
