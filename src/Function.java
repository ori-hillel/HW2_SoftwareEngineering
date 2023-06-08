import javax.swing.text.DefaultEditorKit;

public abstract class Function {
    private final double DEFAULT_EPSILON = 0.00001;

    public abstract double valueAt(double x);
    /*
        Abstract method to calculate the value of the function at a given point
         @param x is a given point (double)
         */

    @Override
    public abstract String toString();
  /* Abstract method to return a string representation of the function*/


    public abstract Function derivative();
    // Abstract method to calculate the derivative of the function
    public double bisectionMethod(double a, double b, double epsilon) {
        /*
    // Bisection method for finding the root of the function within the given interval with a specified epsilon
    @param epsilon is the strict lower bound for right - left (double)
    @ a/b -range (double)
    the function return root
    */
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



    public double bisectionMethod(double a, double b) {
           /*
     * Bisection method for finding the root of the function within the given interval with the default epsilon
    *@param epsilon is the strict lower bound for right - left (double)
    *@ a/b -range (double)
    *the function return  estimated  root
    */
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


    public double newtonRaphsonMethod(double a, double epsilon) {
        /*
         Newton-Raphson method for finding the root of the function starting from a given initial point with a specified epsilon
        *@param epsilon is the strict lower bound (double)
        *@ a is the x0 we start with given as (double)
        *the function return the estimated root
                */

        double root = a;
        Function derivative = this.derivative();

        // Continue the loop until the absolute value of the function at the root is less than epsilon
        do {
            root = root - (this.valueAt(root) / derivative.valueAt(root));
        } while (!(Auxiliary.abs(this.valueAt(root)) < epsilon));

        // Return the estimated root
        return root;
    }

    // Newton-Raphson method for finding the root of the function starting from a given initial point with the default epsilon
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

    // Calculate the Taylor polynomial of the function up to degree n
    public Polynomial taylorPolynomial(int n) {
        /*
        *  Calculate the Taylor polynomial of the function up to degree n
        * @param n is the degree of the polinimial
        * */
        Function f = this;
        double[] coefficients = new double[n+1];
            for (int k = 0; k < n+1; k++) {
                coefficients[k] = f.valueAt(0)/Auxiliary.factorial(k);
                f = f.derivative();
        }
        return new Polynomial(coefficients);
    }


}
