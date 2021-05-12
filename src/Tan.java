public class Tan extends Function{
    private Sin sin;
    private Cos cos;

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calculate(double x) {

        return sin.calculate(x)/cos.calculate(x);
    }
}
