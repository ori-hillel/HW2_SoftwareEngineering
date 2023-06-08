
public class  Negation extends Product {
    /**
     * This class represents a function of type negation.
     * Extends Product class, since (-1) * x = -x.
     */
    public Negation(Function function) {
        super(new Constant(-1), function);
    }
    public Function getFunc() {
        return super.getFuncB();
    }
     /**
     * overrides multiProduct.toString().
     * @return a string which represents the function.
     */
    @Override
    public String toString() {
        return "(-" + super.getFuncB().toString() + ")";
    }
    /**
     * overrides multiProduct.derivative().
     * @return the derivative of the current function.
     */
    @Override
    public Function derivative() {
        return new Negation(getFuncB().derivative());
    }


}
