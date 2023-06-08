public class Sum extends MultiSum {
    /**
     * This class represents a function of type sum.
     * Extends MultiProduct class, since the sum of 2 functions is a sum of n functions, n>=2.
     */
    public Sum(Function A, Function B) {
        super(A,B);
    }
    public Function getFuncA() {
        return super.getFunctions()[0];
    }
    public Function getFuncB() {
        return super.getFunctions()[1];
    }
}
