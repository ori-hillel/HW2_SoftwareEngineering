public class Constant extends Function {
    /**
     * this class represents a constant function.
     * consists of a single attribute (double value).
     */
    private double value;

    public double getValue() {
        return value;
    }

    public Constant(double value) {
        this.value = value;
    }

    /**
     * overrides Function.valueAt(double x)
     * @param x is a given point (double)
     * @return the value of the current function at x
     */
    @Override
    public double valueAt(double x) {
        return this.value;
    }

    /**
     * overrides Function.derivative()
     * @return the derivative of the current function.
     */
    @Override
    public Constant derivative() { return new Constant(0);}

    /**
     * overrides Function.toString()
     * @return a string representation of the current function.
     */
    @Override
    public String toString() {
        /*
        * Return a string representation of the constant
        * */
        if (value / (double)((int)value) == 1 || this.value == 0.0) // this.value is not a fraction
             return "(" + (int)this.value + ")";
        return "(" + this.value + ")";
    }

    /**
     * overrides Function.taylorPolynomial(int n)
     * @param n the order of the Taylor polynomial
     * @return the taylor polynomial of order n
     */
    @Override
    public Polynomial taylorPolynomial(int n) {
        return new Polynomial(value);
    }
}
