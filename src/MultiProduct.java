public class MultiProduct extends Function {
    Function[] functions;
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
        return null;
    }

    @Override
    public Function derivative() {
        return null;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
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
