public class Quotient extends Function {
Function dividend;
Function divisor;
    public Quotient(Function dividend, Function divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
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
       return new Quotient(
                    new Difference(
                        new Product(dividend.derivative(), divisor), new Product(dividend, divisor.derivative())),
                    new Power(divisor, 2));
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        Function quotientFunction = this;
        Root rootFinder= new Root(quotientFunction);
        return rootFinder.findRootByBisection(a,b,epsilon);
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
