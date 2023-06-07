public abstract class Function {
    private final double DEFAULT_EPSILON = 0.00001;
    public abstract double valueAt(double x);
    @Override
    public abstract String toString();
    public abstract Function derivative();
    public double bisectionMethod(double a, double b, double epsilon) {
        double left =a,right =b;
        double mid;
        while(right-left>epsilon){
            mid = (right+left)/2;
            if(this.valueAt(left)*this.valueAt(mid)>0)
                left = mid;
            else
                right=mid;
        }
        return (left+right)/2;
    }
    public double bisectionMethod(double a, double b) {
        double left =a ,right =b;
        double mid;
        while(right-left>DEFAULT_EPSILON){
            mid = (right+left)/2;
            if(this.valueAt(left)*this.valueAt(mid)>0)
                left = mid;
            else
                right=mid;
        }
        return (left+right)/2;
    }
    public double newtonRaphsonMethod(double a, double epsilon) {
        double root = a;
        Function derivative = this.derivative();
        do {
            root = root - (this.valueAt(root) / derivative.valueAt(root));
        } while(Auxiliary.abs(this.valueAt(root)) < epsilon);
        return root - (this.valueAt(root) / derivative.valueAt(root));
    }

    public double newtonRaphsonMethod(double a) {
        double root = a;
        Function derivative = this.derivative();
        do {
            root = root - (this.valueAt(root) / derivative.valueAt(root));
        } while(Auxiliary.abs(this.valueAt(root)) < DEFAULT_EPSILON);
        return root - (this.valueAt(root) / derivative.valueAt(root));
    }
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
