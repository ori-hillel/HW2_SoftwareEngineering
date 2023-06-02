public class Quotient extends Function {
Function function;
    public Quotient(Function function) {
        this.function = function;
    }
    @Override
    public double valueAt(double x) {
        return 1/function.valueAt(x);
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
