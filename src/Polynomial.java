public class Polynomial extends Function {
    private double[] coefficients;

    // Constructor to initialize the Polynomial with an array of coefficients
    public Polynomial(double... coefficients) {
        int size = coefficients.length;
        this.coefficients = new double[size];

        // Copy the coefficients from the input array to the instance variable
        for (int i = 0; i < size; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }

    // Calculate the value of the Polynomial at a given point x
    @Override
    public double valueAt(double x) {
        /*
        * Calculate the value of the Polynomial at a given point x
        * @param x is the point (double)
        * */
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

    // Return a string representation of the Polynomial
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

    // Calculate the derivative of the Polynomial
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
