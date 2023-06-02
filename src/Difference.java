public class Difference extends Sum {
    public Difference(Function A, Function B) {
        super(A, new Negation(B));
    }
}
