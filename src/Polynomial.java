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
        double[] clonedCoefficients = coefficients.clone();
        String ret = "(";
        String temp;
        boolean isFirst = true;
        for (int exp = 0; exp < size; exp++) {
            temp = "";
            if (clonedCoefficients[exp] == 0) {
                if (isFirst) {
                    temp += "0";
                    if (size == 1) {
                        ret += temp;
                        return ret + ")";
                    }
                }
                continue;
            }
            if (!isFirst) {
                if (clonedCoefficients[exp] > 0)
                    temp += " + ";
                else
                    temp += " - ";
            }
            if (clonedCoefficients[exp] < 0 && !isFirst)
                clonedCoefficients[exp] *= -1;
            if (exp == 0) {
                if (Auxiliary.isWholeNumber(clonedCoefficients[exp])) // remove decimal point
                    temp += (int)clonedCoefficients[exp];
                else
                    temp += clonedCoefficients[exp];
            }
            else if (clonedCoefficients[exp] != 1) {
                if (Auxiliary.isWholeNumber(clonedCoefficients[exp])) // remove decimal point
                    temp += (int)clonedCoefficients[exp];
                else
                    temp += clonedCoefficients[exp];
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
