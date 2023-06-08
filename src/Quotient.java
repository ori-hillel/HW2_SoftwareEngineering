public class Quotient extends Function {
    /**
     * This class represents a function of type quotient.
     * Consists of a dividend function, and a divisor function
     */
Function dividend;
Function divisor;
    public Quotient(Function dividend, Function divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    /**
     * overrides Function.valueAt(double x).
     * @param x is a given point (double)
     * @return the value of the  current function at fixed point x
     */
    @Override
    public double valueAt(double x) {
        return dividend.valueAt(x)/divisor.valueAt(x);
    }
    /**
     * overrides Function.toString().
     * @return a string which represents the function.
     */
    @Override
    public String toString() {
        return "(" + dividend.toString() + " / " + divisor.toString() + ")";
    }
    /**
     * overrides Function.derivative().
     * @return the derivative of the current function.
     */
    @Override
    public Quotient derivative() {
       return new Quotient(
                    new Difference(
                        new Product(dividend.derivative(), divisor), new Product(divisor.derivative(), dividend)),
       new Power(divisor, 2));
    }
}
