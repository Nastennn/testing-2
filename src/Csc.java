public class Csc extends Function{
    private Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }


    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }

        return 1/sin.calculate(x);
    }
}
