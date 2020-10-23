package main.Functions;

import main.Decomposers.SinDecomposer;

public class TrigonometryFunctions {

    private final SinDecomposer sin;

    public TrigonometryFunctions(SinDecomposer sin) {
        this.sin = sin;
    }

    public double cos(double x, double eps){
        return sin.calculate(x + Math.PI / 2, eps);
    }

    public double sec(double x, double eps){
        double cos = cos(x, eps);
        return cos == 0 ? Double.NaN : 1 / cos;
    }

    public double tan(double x, double eps){
        double cos = cos(x, eps);
        return cos == 0 ? Double.NaN : sin.calculate(x, eps) / cos;
    }

}
