public class Difference extends Sum {

    public Difference(Function minuend, Function subtrahend) {
        super(minuend, new Negation(subtrahend));
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
