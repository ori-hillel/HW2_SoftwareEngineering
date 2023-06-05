public class Polynomial extends Function {
    private double[] coefficients;
    public Polynomial(double... coefficients) {
        int size = coefficients.length;
        this.coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        Function base;
        Function baseToExponent;
        Function coefficient;
        Function func;
        for (int exp = 0; exp < coefficients.length; exp++) {
            base = new Constant(x);
            if (exp != 0)
                baseToExponent = new Power(base, exp);
            else
                baseToExponent = new Constant(1);
            coefficient = new Constant(coefficients[exp]);
            func = new Product(baseToExponent, coefficient);
            sum += func.valueAt(x);
        }
        return sum;
    }

    @Override
    public String toString() {
        int size = coefficients.length;
        String ret = "(";
        String temp;
        boolean isFirst = true;
        for (int exp = 0; exp < size; exp++) {
            temp = "";
            if (coefficients[exp] == 0)
                continue;
            if (!isFirst) {
                temp += " + ";
            }
            else if (exp == 0){
                if (Auxiliary.isWholeNumber(coefficients[exp])) // remove decimal point
                    temp += (int)coefficients[exp];
                else
                    temp += coefficients[exp];
            }
            else if (coefficients[exp] != 1) {
                if (Auxiliary.isWholeNumber(coefficients[exp])) // remove decimal point
                    temp += (int)coefficients[exp];
                else
                    temp += coefficients[exp];
            }
            if (exp > 0) { // x, x^2, x^3 ...
                if (exp == 1) // x
                    temp += "x";
                else  // x^2, x^3...
                    temp += "x^" + exp;
            }
            isFirst = false;
            ret += temp;
        }
        return ret + ")";
    }

    @Override
    public Polynomial derivative() {
        double[] ret = coefficients.clone();
        for (int i = 0; i < coefficients.length; i++) {
            if (i == coefficients.length - 1)
                ret[i] = 0;
            else
                ret[i] = coefficients[i+1]*(i+1);
        }
        return new Polynomial(ret);
    }
}
