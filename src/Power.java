public class Power extends Function {
    /**
     * This class represents a function of type polynomial.
     * Consists of an exponent (int), and a base (Function)
     */
    private int exponent;
    private Function function;

    public Power(Function function, int exponent) {
        this.function = function;
        this.exponent = exponent;
    }

    /**
     * overrides Function.valueAt(double x).
     * @param x is a given point (double)
     * @return the value of the  current function at fixed point x
     */
    @Override
    public double valueAt(double x) {
        double ret = 1;
        double value = function.valueAt(x);
        for (int i = 0; i < exponent; i++)
            ret *= value;
        return ret;
    }
    /**
     * overrides Function.toString().
     * @return a string which represents the function.
     */
    @Override
    public String toString() {
        return "(" + function.toString() + "^" + exponent + ")";
    }
    /**
     * overrides Function.derivative().
     * @return the derivative of the current function.
     */
    @Override
    public MultiProduct derivative() {
        return new MultiProduct(new Constant(exponent), new Power(function, exponent - 1), function.derivative());
    }
}
