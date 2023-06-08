
public class MultiProduct extends Function {
    /**
     * This class represents a function of type multi product.
     * Consists of an array of functions.
     */
        private Function[] functions;
        public MultiProduct(Function function, Function... functions) {
            this.functions = new Function[functions.length + 1];
            this.functions[0] = function;
            for (int i = 0; i < functions.length; i++)
                this.functions[i + 1] = functions[i];
        }

        public Function[] getFunctions() {
            return functions;
        }

    /**
     * overrides Function.valueAt(double x).
     * @param x is a given point (double)
     * @return the value of the  current function at fixed point x
     */
        @Override
        public double valueAt(double x) {
            double product = 1;
            for (Function f : functions)
                product *= f.valueAt(x);
            return product;
        }

    /**
     * overrides Function.toString().
     * @return a string which represents the function.
     */
        @Override
        public String toString() {
            String ret = "(";
            for (int i = 0; i < functions.length; i++) {
                if (i == 0)
                    ret += functions[i].toString();
                else {
                    ret += " * " + functions[i].toString();
                }
            }
            ret += ")";
            return ret;
        }

    /**
     * overrides Function.derivative().
     * @return the derivative of the current function.
     */
        @Override
        public Function derivative() {
            int size = functions.length;
            Function iDerivative = functions[0].derivative();
            Function[] innerProduct = new Function[size];
            Function[] sum = new Function[size];

            for (int i = 0; i < size; i++) {
                iDerivative = functions[i].derivative();

                for (int j = 0; j < size; j++) {
                    if (j == i)
                        innerProduct[j] = iDerivative;
                    else
                        innerProduct[j] = functions[j];
                }

                sum[i] = new MultiProduct(innerProduct[i], Auxiliary.removeIndex(i, innerProduct));
            }

            return new MultiSum(sum[0], Auxiliary.removeIndex(0, sum));
        }
    }


