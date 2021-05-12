public class System extends Function{
    private Tan tan;
    private Csc csc;
    private Ln ln;
    private Log log;

    public System(Tan tan, Csc csc, Ln ln, Log log){
        this.tan = tan;
        this.csc = csc;
        this.ln = ln;
        this.log = log;
    }
    @Override
    public double calculate(double x) {
        if (x <= 0) {
            double a = tan.calculate(x) + csc.calculate(x);
            double b = Math.pow(csc.calculate(x) - tan.calculate(x) - csc.calculate(x) - tan.calculate(x), 3);
            return a + b;
        }
        else {
            double left =
                    (
                        ((log.log(x, 3)/log.log(x, 3))*log.log(x, 2))

                         / ((ln.calculate(x) - ln.calculate(x)) + log.log(x, 3))
                    )

                    / (ln.calculate(x) * log.log(x, 5));
            double right = ((Math.pow((ln.calculate(x)*Math.pow(log.log( x, 3), 2)),3))-((log.log(x, 2))/ log.log(x, 3)));
            return left * right;
        }
    }

}
