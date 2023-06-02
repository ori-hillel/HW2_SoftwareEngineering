
public class Negation extends Product {
    public Negation(Function function) {
        super(new Constant(-1), function);
    }
    @Override
    public String toString() {
        return "(-" + super.getFuncA().toString() + ")";
    }
}
