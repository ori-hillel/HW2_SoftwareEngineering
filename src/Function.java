import javax.swing.text.DefaultEditorKit;

public abstract class Function {
    /**
     * abstract class, which represents a function.
     */
    private static final double DEFAULT_EPSILON = 0.00001;

    /**
     * Abstract method to calculate the value of the function at a given point
     * @param x is a given point (double)
     * @return the value of the  current function at fixed point x
     */
    public abstract double valueAt(double x);

    /**
     * Overrides object.toString().
     * @return a string which represents the function.
     */

    @Override
    public abstract String toString();

    /**
     * derives the current function.
     * @return the derivative of the current function.
     */
    public abstract Function derivative();

    /**
     * returns thr root with respect to a given absolute error epsilon, of the current function in a given closed interval [a, b].
     * @param a the start point of the interval
     * @param b the end point of the interval
     * @param epsilon the absolute given error
     * @return the function's root in [a, b], with respect to epsilon.
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a, right = b;
        double mid;

        // Continue the loop until the difference between the left and right bounds is less than epsilon
        while (right - left > epsilon) {
            mid = (right + left) / 2;

            // Check if the function values at left and mid have the same sign
            if (this.valueAt(left) * this.valueAt(mid) > 0)
                left = mid; // Update the left bound
            else
                right = mid; // Update the right bound
        }

        // Return the midpoint of the final interval as the estimated root
        return (left + right) / 2;
    }


    /**
     * returns thr root with respect to a default absolute error epsilon = 10^-5, of the current function in a given closed interval [a, b].
     * @param a the start point of the interval
     * @param b the end point of the interval
     * @return the function's root in [a, b], with respect to epsilon.
     */
    public double bisectionMethod(double a, double b) {
        double left = a, right = b;
        double mid;

        // Continue the loop until the difference between the left and right bounds is less than the default epsilon
        while (right - left > DEFAULT_EPSILON) {
            mid = (right + left) / 2;

            // Check if the function values at left and mid have the same sign
            if (this.valueAt(left) * this.valueAt(mid) > 0)
                left = mid; // Update the left bound
            else
                right = mid; // Update the right bound
        }

        // Return the midpoint of the final interval as the estimated root
        return (left + right) / 2;
    }

    /**
     * calculates the root of the current function, nearby the fixed given point a, with respect to a given error (epsilon)
     * @param a the fixed point
     * @param epsilon the absolute error
     * @return the root of the function, nearby fixed point a
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double root = a;
        Function derivative = this.derivative();

        // Continue the loop until the absolute value of the function at the root is less than epsilon
        do {
            root = root - (this.valueAt(root) / derivative.valueAt(root));
        } while (!(Auxiliary.abs(this.valueAt(root)) < epsilon));

        // Return the estimated root
        return root;
    }

    /**
     * calculates the root of the current function, nearby the fixed given point a, with respect to a default error (epsilon = 10^-5)
     * @param a teh fixed given point
     * @return the root of the function, nearby fixed point a
     */
    public double newtonRaphsonMethod(double a) {
        /*
        Newton-Raphson method for finding the root of the function starting from a given initial point with the default epsilon

         */
        double root = a;
        Function derivative = this.derivative();

        // Continue the loop until the absolute value of the function at the root is less than the default epsilon
        do {
            root = root - (this.valueAt(root) / derivative.valueAt(root));
        } while (!(Auxiliary.abs(this.valueAt(root)) < DEFAULT_EPSILON));

        // Return the estimated root
        return root;
    }

    /**
     * calculates the Taylor polynomial of a given order n, of the current function.
     * @param n the order of the Taylor polynomial
     * @return the taylor polynomial of order n
     */
    public Polynomial taylorPolynomial(int n) {
        Function f = this;
        double[] coefficients = new double[n+1];
            for (int k = 0; k < n+1; k++) {
                coefficients[k] = f.valueAt(0)/Auxiliary.factorial(k);
                f = f.derivative();
        }
        return new Polynomial(coefficients);
    }


}
