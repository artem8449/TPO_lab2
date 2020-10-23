package main.Decomposers;

public class LogDecomposer {

    public double calculate(Double x, Double eps){
        if (x.isInfinite() || x.isNaN() || eps.isNaN() || eps.isInfinite() || eps == 0. || x <= 0)
            return Double.NaN;

        double prevRes, res = 0;
        int i = 0;
        do {
            prevRes = res;
            res += Math.pow((x - 1) / (x + 1), 2 * i + 1) / (2 * i + 1);
            i++;
        } while(Math.abs(prevRes - res) > eps);
        return 2 * res;
    }
}
