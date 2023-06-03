public class Power extends Function {
    private int exponent;
    private Function function;

    public Power(Function function, int exponent) {
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
}
