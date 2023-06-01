public class Constant extends Function {
    double value;
    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return this.value;
    }
@Override
    public Function derivative() { return new Constant(0);}
@Override
    public Function taylorPolynomial(int n) {
        return new Constant(0);
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
    public String toString() {
        return null;
    }
}
