
public class MultiProduct extends Function {
        private Function[] functions;

        // Constructor to initialize the MultiProduct with a main function and additional functions
        public MultiProduct(Function function, Function... functions) {
            this.functions = new Function[functions.length + 1];
            this.functions[0] = function;
            for (int i = 0; i < functions.length; i++)
                this.functions[i + 1] = functions[i];
        }

        // Get the array of functions
        public Function[] getFunctions() {
            return functions;
        }

        // Calculate the value of the MultiProduct at a given point x
        @Override
        public double valueAt(double x) {
        /*    Calculate the value of the MultiProduct at a given point x
        *@param x is the given point (double)
        * */
            double product = 1;
            for (Function f : functions)
                product *= f.valueAt(x);
            return product;
        }


        @Override
        public String toString() {
            // Return a string representation of the MultiProduct
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


        @Override
        public Function derivative() {
            // Calculate the derivative of the MultiProduct
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


