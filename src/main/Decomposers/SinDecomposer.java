package main.Decomposers;


public class SinDecomposer {

    private double factorial(int x) {
        double val = 1;
        for (int i = 2; i <= x; i++)
            val *= i;
        return val;
    }

    public double calculate(Double x, Double eps){
        if (x.isInfinite() || x.isNaN() || eps.isNaN() || eps.isInfinite() || eps == 0.)
            return Double.NaN;

        double prevRes, res = 0;
        int i = 0;
        do {
            prevRes = res;
            res += (Math.pow(-1, i) * Math.pow(x, (2 * i + 1))) / factorial(2 * i + 1);
            i++;
        } while(Math.abs(prevRes - res) > eps);

        return res;
    }

}