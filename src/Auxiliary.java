public abstract class Auxiliary {
    /**
     * abstract class, which includes many sufficient auxiliary static function for the current assignment.
     */

    /**
     * removes a function from an arbitrary given number of functions, and returns the rest of the functions.
     * @param index the function which the user desires to remove.
     * @param f the given function (varargs)
     * @return an array of functions (the rest of the functions)
     */
    public static Function[] removeIndex(int index, Function... f) {
        int size = f.length;
        Function[] ret = new Function[size - 1];
        for (int i = 0; i < size; i++) {
            if (i < index)
                ret[i] = f[i];
            else if (i > index)
                ret[i - 1] = f[i];
        }

        return ret;
    }

    /**
     * calculates the factorial of a given double (x).
     * @param x the number which the user asks to calculate its factorial
     * @return the factorial of x
     */
    public static double factorial(double x) {
        double result = 1.0;
        for (int i = 2; i <= x; i++)
            result *= i;
        return result;
    }

    /**
     * receives a number, and checks whether a given double (num) is a whole number or a fraction.
     * @param num the given double
     * @return true if num is a whole number, false otherwise.
     */
    public static boolean isWholeNumber(double num) {
        return (num % 1) == 0;
    }

    /**
     * calculates the absolute value of a given double (num).
     * @param num a given double
     * @return the absolute value of num
     */
    public static double abs(double num) { return ((num > 0) ?  num : -num);}

    /**
     * recieves 2 arrays of doubles, and checks whether the arrays are equal to each other.
     * @param arr1 array #1
     * @param arr2 array #2
     * @return true if the arrays are equal, false otherwise.
     */
    public static boolean compareArrays(double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length) return false;
        int size = arr1.length;
        for (int i = 0; i < size; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}
