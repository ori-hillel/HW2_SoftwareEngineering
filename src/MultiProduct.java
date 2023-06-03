public class MultiProduct extends Function {
    private Function[] functions;

    public Function[] getFunctions() {
        return functions;
    }

    public MultiProduct(Function function, Function ... functions) {
        this.functions = new Function[functions.length + 1];
        functions[0] = function;
        for (int i = 1; i < this.functions.length; i++)
            this.functions[i] = functions[i];
    }

    @Override
    public double valueAt(double x) {
        double product = 1;
        for (Function f: functions)
            product += f.valueAt(x);
        return product;
    }

    @Override
    public String toString() {
        String ret = "(";
        for (int i = 0; i < functions.length; i++) {
            if (i == 0)
                ret += functions[i].toString();
            else {
                ret += "*" + functions[i].toString();
            }
        }
        ret += ")";
        return ret;
    }

    @Override
    public Function derivative() {
        Function temp;
        Function[] ret = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            temp = functions[i];
            for (int j = 0; j < functions.length; j++) {
                if (i == j)
                    functions[i] = new Constant(1);
                ret[i] = new MultiProduct(functions[i].derivative(), functions);
            }
        functions[i] = temp;
        }
        return new MultiProduct(new Constant(1), ret);
    }
    @Override
    public Function taylorPolynomial(int n) {
        return null;
    }
}
