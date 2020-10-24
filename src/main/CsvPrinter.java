package main;

import au.com.bytecode.opencsv.CSVWriter;
import main.Decomposers.LogDecomposer;
import main.Decomposers.SinDecomposer;
import main.Functions.LogNFunctions;
import main.Functions.TrigonometryFunctions;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class CsvPrinter {

    interface FunctionInterface {
        double calculate(double x, double eps);
    }

    private static TreeMap<Double, Double> getValues(FunctionInterface method, double step, double startAt, double endAt){
        TreeMap<Double, Double> values = new TreeMap<>();
        double EPS = 0.0001;
        for (double i = startAt; i <= endAt; i += step)
            values.put(i, method.calculate(i, EPS));

        return values;
    }

    public static void print(FunctionInterface method, double step, double startAt, double endAt, String fileName){

            TreeMap<Double, Double> values = getValues(method, step, startAt, endAt);

            File file = new File(fileName);
            try {
                FileWriter fileWriter = new FileWriter(file);
                CSVWriter csvWriter = new CSVWriter(fileWriter);
                String[] header = { "x", "y" };
                csvWriter.writeNext(header);

                for(Map.Entry<Double, Double> entry : values.entrySet()) {
                    String[] str = { Double.toString(entry.getKey()), Double.toString(entry.getValue()) };
                    csvWriter.writeNext(str);
                }

                csvWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SinDecomposer sinDecomposer = new SinDecomposer();
        LogDecomposer logDecomposer = new LogDecomposer();

        TrigonometryFunctions trigonometryFunctions = new TrigonometryFunctions(sinDecomposer);
        LogNFunctions logNFunctions = new LogNFunctions(logDecomposer);

        EquationSystem equationSystem = new EquationSystem(trigonometryFunctions, logNFunctions);

        print(sinDecomposer::calculate, 0.1, -7, 7, "D:\\testingPO\\lab2csv\\sinDecomposer.csv");
        print(logDecomposer::calculate, 0.1, -7, 7, "D:\\testingPO\\lab2csv\\logDecomposer.csv");
        print(equationSystem::calculate, 0.1, -7, 7, "D:\\testingPO\\lab2csv\\systemEquations.csv");

    }

}
