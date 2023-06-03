public class Sum extends MultiSum {
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
