public class Polynomial extends Function {
    private double[] coefficients;
    public Polynomial(double... coefficients) {

    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        Function base;
        Function baseToExponent;
        Function coefficient;
        Function func;
        for (int exp = 0; exp < coefficients.length; exp++) {
            base = new Constant(exp);
            baseToExponent = new Power(base, exp);
            coefficient = new Constant(coefficients[exp]);
            func = new Product(baseToExponent, coefficient);
            sum += func.valueAt(x);
        }
        return sum;
    }

    @Override
    public String toString() {
        String ret = "(";
        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0)
                ret += coefficients[i];
            else {
                ret += " + " + coefficients[i];
            }
        }
        ret += ")";
        return ret;
        }

    @Override
    public Polynomial derivative() {
        double[] ret = coefficients.clone();
        for (int i = 0; i < coefficients.length; i++) {
            if (i == coefficients.length - 1)
                ret[i] = 0;
            ret[i] = coefficients[i+1]*(i+1);
        }
        return new Polynomial(ret);
    }
}
