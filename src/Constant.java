public class Constant extends Function {
    private double value;
    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return this.value;
    }
@Override
    public Function derivative() { return new Constant(0);}
    @Override
    public String toString() {
        return "(" + this.value + ")";
    }
}
