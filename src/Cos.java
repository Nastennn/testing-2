public class Cos extends Function{
    private Sin sin;

    public Cos (Sin sin){
        this.sin = sin;
    }

    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        double result = 0;
        if (x < 0) x = -x;
        while (x >= Math.PI) {
            x -= 2 * Math.PI;
        }
        if (x < 0) x = -x;
        result = Math.sqrt(1 - Math.pow(sin.calculate(x), 2));
        if (x >= 0 && x <= Math.PI / 2) return result;
        else return -result;
    }


}
