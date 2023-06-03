public class Root {
    private final double DEFAULT_EPSILON = 0.00001;

    private static Function function;
    public Root(Function function) {
        this.function=function;
    }
    public double findRootByBisection(double a, double b, double epsilon) {
        double left =a,right =b;
        double mid;
        while(right-left>epsilon){
            mid = (right+left)/2;
            if(function.valueAt(left)*function.valueAt(mid)>0)
                left = mid;
            else
                right=mid;
        }
        return (left+right)/2;
    }
    public double findRootByBisection(double a, double b) {
        double left =a,right =b;
        double mid;
        while(right-left>DEFAULT_EPSILON){
            mid = (right+left)/2;
            if(function.valueAt(left)*function.valueAt(mid)>0)
                left = mid;
            else
                right=mid;
        }
        return (left+right)/2;
    }

}
