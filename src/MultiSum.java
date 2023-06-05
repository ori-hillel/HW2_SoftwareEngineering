public class MultiSum extends Function {
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

    @Override
    public double valueAt(double x) {
        double sum = 0;
        for (Function f: functions)
            sum += f.valueAt(x);
        return sum;
    }

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

    @Override
    public MultiSum derivative() {
        Function[] ret = new Function[functions.length];
        for (int i  = 0; i < functions.length; i++)
            ret[i] = functions[i].derivative();
        return new MultiSum(ret[0], Auxiliary.removeIndex(0, ret));
    }


    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    @Override
    public Function taylorPolynomial(int n) {
        return null;
    }
}
