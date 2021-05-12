public class Sin extends Function {
    @Override
    public double calculate(double x) {
        if (Double.isNaN(x)) {
            throw new IllegalArgumentException("NaN passed as a parameter to sin");
        }
        if (Double.isInfinite(x)) {
            return Double.NaN;
        }
        x = cutX(x);

        double result = 0;
        double pow = x;
        long fact = 1;
        short sign = 1;

        for (int i = 1; i < 9; i++) {
            result += sign * pow / fact;
            sign *= -1;
            pow *= x * x;
            fact *= (long) (i * 2) * (i * 2 + 1);
        }

        return result;
    }

    private double cutX(double x) {
        if (x >= Math.PI) {
            while (x >= Math.PI) {
                x -= 2 * Math.PI;
            }
        } else if (x <= -Math.PI) {
            while (x <= -Math.PI) {
                x += 2 * Math.PI;
            }
        }
        return x;
    }
}
