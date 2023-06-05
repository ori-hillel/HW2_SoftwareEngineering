
public class  Negation extends Product {
    public Negation(Function function) {
        super(new Constant(-1), function);
    }
    public Function getFunc() {
        return super.getFuncB();
    }
    @Override
    public String toString() {
        return "(-" + super.getFuncB().toString() + ")";
    }
    @Override
    public Function derivative() {
        return new Negation(getFuncB());
    }


}
