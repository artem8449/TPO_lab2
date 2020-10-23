package main;

import main.Decomposers.LogDecomposer;
import main.Decomposers.SinDecomposer;
import main.Functions.LogNFunctions;
import main.Functions.TrigonometryFunctions;

public class EquationSystem {
    private final LogNFunctions logN;
    private final TrigonometryFunctions trigonometry;
    private final SinDecomposer sin;
    private final LogDecomposer log;

    public EquationSystem(SinDecomposer sin, LogDecomposer log, TrigonometryFunctions trigonometry, LogNFunctions logN) {
        this.logN = logN;
        this.trigonometry = trigonometry;
        this.sin = sin;
        this.log = log;
    }

    public double calculate(double x, double eps){
        return (x > 0)? func1(x, eps) : func2(x, eps);
    }

    private double func1(double x, double eps) {
        double log2 = logN.log(x, eps, 2);
        double log3 = logN.log(x, eps, 3);
        double log5 = logN.log(x, eps, 5);
        double log10 = logN.log(x, eps, 10);
        double log = this.log.calculate(x, eps);
        double denominator = (log2 + log10) - (log - (log - log5));
        return (denominator == 0 || log5 == 0) ? Double.NaN : (((Math.pow((Math.pow((log3 + log3), 3)), 2)) / denominator) - ((log / log5) * (Math.pow((Math.pow(log10, 3)), 2))));
    }

    private double func2(double x, double eps) {
        double cos = trigonometry.cos(x, eps);
        double sec = trigonometry.sec(x, eps);
        double tan = trigonometry.tan(x, eps);
        return (sec == 0)? Double.NaN : (((((tan / sec) + sec) * cos) + cos) / sec);
    }

}
