public abstract class Auxiliary {
    public static Function[] removeFirst(Function ... f) {
        int size = f.length;
        Function[] ret = new Function[size - 1];
        for (int i = 1; i < size; i++)
            ret[i-1] = f[i];
        return ret;
    }

    public static double factorial(double x) {
        double result = 1.0;
        for (int i = 2; i <=x; i++)
            result *= i;
        return result;
    }
}
