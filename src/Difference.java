public class Difference extends Sum {

    public Difference(Function minuend, Function subtrahend) {
        super(minuend, subtrahend);
    }
    @Override
    public double valueAt(double x) {
        return getMinuend().valueAt(x) - getSubtrahend().valueAt(x);
    }
    @Override
    public Difference derivative() {
        return new Difference(getMinuend().derivative(), getSubtrahend().derivative());
    }
    public Function getMinuend() {
        return super.getFuncA();
    }
    public Function getSubtrahend() {
        return super.getFuncB();
    }
    @Override
    public String toString() {
        return "(" + super.getFuncA().toString() + " - " + super.getFuncB().toString() + ")";
    }
}
