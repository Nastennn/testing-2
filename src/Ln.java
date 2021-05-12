public class Ln extends Function{
    public double accuracy = 0.000000001;


    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x))
            throw new NullPointerException();
        if (x == 1) return 0;
        double z = (x - 1) / (x + 1);
        double preSum = 0;
        double sum = 2 * z;
        int i = 1;
        while (Math.abs(-preSum + sum) > 0.001) {
            preSum = sum;
            sum += 2 * Math.pow(z
                    , 2 * i + 1) / (2 * i + 1);
            i++;
        }
        return sum;
    }
}
