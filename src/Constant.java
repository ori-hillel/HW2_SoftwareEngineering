public class Constant extends Function {
    private double value;

    public double getValue() {
        return value;
    }

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return this.value;
    }
@Override
    public Constant derivative() { return new Constant(0);}
    @Override
    public String toString() {
        if (value / (double)((int)value) == 1 || this.value == 0.0) // this.value is not a fraction
             return "(" + (int)this.value + ")";
        return "(" + this.value + ")";
    }
    @Override
    public Constant taylorPolynomial(int n) {
        return new Constant(value);
    }
}
