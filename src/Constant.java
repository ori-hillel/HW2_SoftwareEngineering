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
    public Constant derivative() { return new Constant(0);}
    @Override
    public String toString() {
        if (value / (double)((int)value) == 1) // this.value is not a fraction
             return "(" + (int)this.value + ")";
        return "(" + this.value + ")";
    }
}
