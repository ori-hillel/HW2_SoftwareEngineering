public class MultiSum extends Function {
    /**
     * This class represents a function of type multi sum.
     * Consists of an array of functions.
     */
    private Function[] functions;

    public Function[] getFunctions() {
        return functions;
    }

    public MultiSum(Function function, Function ... functions) {
        this.functions = new Function[functions.length + 1];
        this.functions[0] = function;
        for (int i = 0; i < functions.length; i++)
            this.functions[i+1] = functions[i];
    }
    /**
     * overrides Function.valueAt(double x).
     * @param x is a given point (double)
     * @return the value of the  current function at fixed point x
     */
    @Override
    public double valueAt(double x) {
        double sum = 0;
        for (Function f: functions)
            sum += f.valueAt(x);
        return sum;
    }
    /**
     * overrides Function.toString().
     * @return a string which represents the function.
     */
    @Override
    public String toString() {
        String ret = "(";
        for (int i = 0; i < functions.length; i++) {
            if (i != 0)
                ret += " + ";
            ret += functions[i].toString();
        }
        ret += ")";
        return ret;
    }
    /**
     * overrides Function.derivative().
     * @return the derivative of the current function.
     */
    @Override
    public MultiSum derivative() {
        Function[] ret = new Function[functions.length];
        for (int i  = 0; i < functions.length; i++)
            ret[i] = functions[i].derivative();
        return new MultiSum(ret[0], Auxiliary.removeIndex(0, ret));
    }
}
