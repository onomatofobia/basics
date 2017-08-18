package pl.com.bottega.homework.improved;

import java.util.Scanner;

public class PolynomialFuntionTest {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        double a = readParameter("a");
        double b = readParameter("b");
        double c = readParameter("c");

        PolynomialFunction function = new PolynomialFunction(a, b, c);

        function.solve();

        double extremum = function.getExtremum();
        extremum = function.getExtremum();
        extremum = function.getExtremum();

    }

    private static double readParameter(String coefficient) {
        System.out.print("Podaj " + coefficient + ": ");
        return scanner.nextDouble();
    }
}
