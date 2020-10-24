package main.Functions;

import main.Decomposers.LogDecomposer;

public class LogNFunctions {

    private final LogDecomposer log;

    public LogNFunctions(LogDecomposer log) {
        this.log = log;
    }

    public double log(double x, double eps, double base){
        double lnBase = log.calculate(base, eps);
        return lnBase == 0 ? Double.NaN : log.calculate(x, eps) / lnBase;

    }

}
