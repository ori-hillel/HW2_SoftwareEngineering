public abstract class Auxiliary {
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

    public static double factorial(double x) {
        double result = 1.0;
        for (int i = 2; i <= x; i++)
            result *= i;
        return result;
    }

    public static boolean isWholeNumber(double num) {
        return (num % 1) == 0;
    }
    public static double abs(double num) { return ((num > 0) ?  num : -num);}

    public static boolean compareArrays(double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length) return false;
        int size = arr1.length;
        for (int i = 0; i < size; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}
