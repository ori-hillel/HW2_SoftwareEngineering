public class Product extends MultiProduct {
    /**
     * This class represents a function of type product.
     * Extends MultiProduct class, since the product of 2 functions is a product of n functions, n>=2.
     */
    public Product (Function A, Function B) {
        super(A, B);
    }
    public Function getFuncA() {
        return super.getFunctions()[0];
    }
    public Function getFuncB() {
        return super.getFunctions()[1];
    }
}
