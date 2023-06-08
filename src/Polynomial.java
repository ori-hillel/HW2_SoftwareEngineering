public class Polynomial extends Function {
    /**
     * This class represents a function of type polynomial.
     * Consists of an array of coefficients (type double).
     */
    private double[] coefficients;

    public Polynomial(double... coefficients) {
        int size = coefficients.length;
        this.coefficients = new double[size];

        for (int i = 0; i < size; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }
    /**
     * overrides Function.valueAt(double x).
     * @param x is a given point (double)
     * @return the value of the  current function at fixed point x
     */
    @Override
    public double valueAt(double x) {
        double sum = 0;
        Function base;
        Function baseToExponent;
        Function coefficient;
        Function func;

        // Iterate over the coefficients and calculate the polynomial value for each exponent
        for (int exp = 0; exp < coefficients.length; exp++) {
            base = new Constant(x);

            // Create the base raised to the exponent function
            if (exp != 0)
                baseToExponent = new Power(base, exp);
            else
                baseToExponent = new Constant(1);

            coefficient = new Constant(coefficients[exp]);
            func = new Product(baseToExponent, coefficient);

            // Add the evaluated function value to the sum
            sum += func.valueAt(x);
        }

        return sum;
    }
    /**
     * overrides Function.toString().
     * @return a string which represents the function.
     */
    @Override
    public String toString() {
        int size = coefficients.length;

        // Check if the polynomial is zero
        if (Auxiliary.compareArrays(coefficients, new double[size]))
            return "(0)";

        double[] clonedCoefficients = coefficients.clone();
        String ret = "(";
        String temp;
        boolean isFirst = true;

        // Iterate over the coefficients and create the string representation
        for (int exp = 0; exp < size; exp++) {
            temp = "";

            // Skip if the coefficient is zero
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

            // Handle negative coefficients
            if (clonedCoefficients[exp] < 0 && !isFirst)
                clonedCoefficients[exp] *= -1;

            // Append the coefficient
            if (exp == 0) {
                if (Auxiliary.isWholeNumber(clonedCoefficients[exp])) // remove decimal point
                    temp += (int) clonedCoefficients[exp];
                else
                    temp += clonedCoefficients[exp];
            } else if (clonedCoefficients[exp] != 1) {
                if (Auxiliary.isWholeNumber(clonedCoefficients[exp])) // remove decimal point
                    temp += (int) clonedCoefficients[exp];
                else
                    temp += clonedCoefficients[exp];
            }

            // Append the exponent part
            if (exp > 0) { // x, x^2, x^3 ...
                if (exp == 1) // x
                    temp += "x";
                else // x^2, x^3...
                    temp += "x^" + exp;
            }

            isFirst = false;
            ret += temp;
        }

        return ret + ")";
    }
    /**
     * overrides Function.derivative().
     * @return the derivative of the current function.
     */
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
