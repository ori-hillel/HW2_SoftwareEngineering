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
        double left =a,right =b;
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
        return 0;
    }

    public double newtonRaphsonMethod(double a) {
        return 0;
    }
    public Function taylorPolynomial(int n) {
        Function derivative = this;
        double[] coefficients = new double[n];
        for (int k = 0; k < n; k++) {
            coefficients[k] = derivative.valueAt(0)/Auxiliary.factorial(k);
            derivative = derivative.derivative();
        }
        return new Polynomial(coefficients);
    }


}
