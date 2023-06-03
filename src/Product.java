public class Product extends MultiProduct {
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
