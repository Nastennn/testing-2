public class Log{
    private Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double log(double x, int b) {
        return ln.calculate(x) / ln.calculate(b);
    }

}
