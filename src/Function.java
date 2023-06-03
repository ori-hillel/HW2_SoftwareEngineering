public abstract class Function {
    public abstract double valueAt(double x);
    @Override
    public abstract String toString();
    public abstract Function derivative();
    public abstract double bisectionMethod(double a, double b, double epsilon);
    public abstract double bisectionMethod(double a, double b);

    public abstract double newtonRaphsonMethod(double a, double epsilon);
    public abstract Function taylorPolynomial(int n);

}
