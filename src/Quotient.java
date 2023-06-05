public class Quotient extends Function {
Function dividend;
Function divisor;
    public Quotient(Function dividend, Function divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    @Override
    public double valueAt(double x) {
        return dividend.valueAt(x)/divisor.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + dividend.toString() + " / " + divisor.toString() + ")";
    }

    @Override
    public Quotient derivative() {
       return new Quotient(
                    new Difference(
                        new Product(dividend.derivative(), divisor), new Product(dividend, divisor.derivative())),
       new Power(divisor, 2));
    }
}
